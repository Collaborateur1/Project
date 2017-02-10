package controller.route;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.core.JsonProcessingException;

import json.Availabilitys;
import model.bean.Appointment;
import model.bean.Availability;
import model.bean.Schedule;
import model.bean.ScheduleDay;
import model.job.GenericJob;
import other.SpringFactory;

@Path( "/availability" )
public class RouteAvailability {
    private static Logger logger = Logger.getLogger( RouteAvailability.class );

    @javax.annotation.security.PermitAll
    @GET
    @Path( "{id}/{day}/{month}/{year}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response get( @PathParam( "id" ) String id, @PathParam( "day" ) Integer day,
            @PathParam( "month" ) Integer month,
            @PathParam( "year" ) Integer year,
            @QueryParam( value = "limit" ) Integer limit) throws JsonProcessingException {

        String startdate = day + "/" + month + "/" + year;

        if ( id == null || "".equals( id ) || startdate == null )
            return Response.status( Response.Status.OK ).build();

        // get the generic service object to fetch object from the database
        GenericJob geniricService = SpringFactory.getGenericJob();
        // startdate = DateTime.now().minusDays( 10 ).toDate();
        // enddate = DateTime.now().plusDays( 2 ).toDate();
        try {
            // retrieve hairdresser schedule (planing)
            List<Schedule> result = geniricService.getListObjectV1( Schedule.class,
                    new String[][] { { "hairdresser.hairId", "=", id } }, null,
                    new String[][] { { "scheHairdresser", "hairdresser" } } );

            // we need to update startdDt so we use a MutableDateTime
            MutableDateTime startdDt = new MutableDateTime(
                    DateTimeFormat.forPattern( "dd/MM/yyyy" ).parseDateTime( startdate.trim() ) );

            if ( limit == null || limit > 6 || limit == 0 )
                limit = 6;

            DateTime endDt = addDay( startdate, limit );
            Instant beg = startdDt.toInstant();
            Instant end = endDt.toInstant();
            Interval interval = new Interval( beg, end );

            if ( interval.toDuration().toStandardDays().getDays() > 7 ) {
                MutableDateTime temp = new MutableDateTime( startdDt );
                temp.setHourOfDay( 23 );
                endDt = temp.toDateTime();
                endDt.plusDays( 6 );

            }

            Schedule sche = null;
            if ( ( result != null && !result.isEmpty() ) )
                sche = result.get( 0 );
            else
                return Response.status( Response.Status.OK ).build();

            // planing for each day of the week
            List<ScheduleDay> planingForTheWeek = sche.getScheScheDays();
            Availabilitys avbs = new Availabilitys();

            List<Appointment> appointments = null;

            // we don't load the appointment list from the start for
            // optimization purpose
            // we first check the availability day
            boolean firstload = true;
            int j = 0;

            // planing of the "startdDt" day (contain the list of Availabilitys
            // for the day)
            ScheduleDay scheduleDay = null;

            // Availability list of the "startdDt" day
            List<Availability> availabilitys = null;
            while ( startdDt.isBefore( endDt ) ) {

                // find list Availability matching to the date (JAVA8 LAMBDA
                // expressions)
                scheduleDay = planingForTheWeek.stream().filter( sc -> sc.getScheDay() == startdDt.getDayOfWeek() )
                        .findAny()
                        .orElse( null );
                // initialize the day availabilitys
                if ( scheduleDay != null )
                    availabilitys = scheduleDay.getScheDayAvailability();
                else
                    availabilitys = new ArrayList<>();

                if ( !availabilitys.isEmpty() ) {
                    // load appointments at need
                    if ( firstload ) {

                        appointments = geniricService.getListObjectV1( Appointment.class,
                                new String[][] { { "hairdresser.hairId", "=", id },
                                        { "appoStartDate", ">=DT", startdDt.toString() },
                                        { "appoEndDate", "<=DT", endDt.toString() } },
                                new String[][] { { "ACS", "appoStartDate" } },
                                new String[][] { { "appoHairdresser", "hairdresser" } } );
                        firstload = false;
                    }
                    // no appointments for the current day, we load the entire
                    // availabilitys
                    if ( appointments == null || appointments.isEmpty() || j >= appointments.size()
                            || appointments.get( j ).getAppoStartDate().getDayOfYear() != startdDt.getDayOfYear() ) {

                        for ( int p = 0; p < availabilitys.size(); p++ ) {
                            if ( availabilitys.get( p ).getavaiEndDate().getMinuteOfDay() >= startdDt
                                    .getMinuteOfDay() ) {

                                if ( availabilitys.get( p ).getavaiStartDate().getMinuteOfDay() < startdDt
                                        .getMinuteOfDay() )
                                    availabilitys.get( p ).setavaiStartDate( startdDt.toDateTime() );

                                availabilitys.get( p ).setDay( new MutableDateTime( startdDt ) );
                                avbs.addAvailabilitys( availabilitys.get( p ) );
                            }
                        }

                    } else {

                        int i = 0;
                        Appointment appointment = null;
                        Availability availability = null;
                        // for all appointment
                        while ( j < appointments.size()
                                && appointments.get( j ).getAppoStartDate().getDayOfYear() == startdDt
                                        .getDayOfYear() ) {
                            appointment = appointments.get( j );
                            // for all availability
                            while ( i < availabilitys.size() ) {

                                if ( availabilitys.get( i ).getavaiEndDate().getMinuteOfDay() > startdDt
                                        .getMinuteOfDay() ) {
                                    if ( availabilitys.get( i ).getavaiStartDate()
                                            .getMinuteOfDay() < ( startdDt.getMinuteOfDay() ) ) {
                                        availabilitys.get( i ).setavaiStartDate( startdDt.toDateTimeISO() );
                                    }

                                    // if the appointment is not in the
                                    // availability schedule the availability is
                                    // free (left to the availabilitys time)
                                    if ( appointment.getAppoStartDate().getMinuteOfDay() > availabilitys.get( i )
                                            .getavaiEndDate().getMinuteOfDay()
                                            || appointment.getAppoEndDate().getMinuteOfDay() < availabilitys.get( i )
                                                    .getavaiStartDate().getMinuteOfDay() ) {

                                        avbs.addAvailabilitys( availabilitys.get( i ) );

                                    } else {

                                        availability = availabilitys.get( i );
                                        // check if the appointment start time
                                        // is not at the beginning of the
                                        // availability
                                        if ( availability.getavaiStartDate().getMinuteOfDay() < appointment
                                                .getAppoStartDate().getMinuteOfDay() ) {
                                            Availability newAvailb = new Availability();
                                            newAvailb.setavaiId( availability.getavaiId() );
                                            newAvailb.setavaiStartDate(
                                                    new DateTime( availability.getavaiStartDate() ) );
                                            newAvailb.setavaiEndDate( appointment.getAppoStartDate() );
                                            newAvailb.setDay( new MutableDateTime( startdDt ) );
                                            avbs.addAvailabilitys( newAvailb );

                                            // check if the appointment end time
                                            // is not at the end of the
                                            // availability
                                            if ( appointment.getAppoEndDate().getMinuteOfDay() < availability
                                                    .getavaiEndDate().getMinuteOfDay() ) {
                                                // we update the availability
                                                // for the next appointment
                                                availability.setavaiStartDate( appointment.getAppoEndDate() );
                                            } else {
                                                // the appointment use all the
                                                // availability, so there is no
                                                // free time left we pass to the
                                                // next availability
                                                i++;
                                            }

                                        } else if ( appointment.getAppoEndDate().getMinuteOfDay() == availability
                                                .getavaiEndDate().getMinuteOfDay() ) {
                                            // the appointment start time is at
                                            // the beginning of the availability
                                            // and
                                            // the appointment end time is at
                                            // the end of the availability
                                            // so there is no free time left we
                                            // pass to the next availability
                                            i++;

                                        } else {
                                            // the appointment start time is at
                                            // the beginning of the availability
                                            // so we update the availability to
                                            // check at the next iteration if
                                            // there is free time left

                                            availability.setavaiStartDate( appointment.getAppoEndDate() );

                                        }

                                        // we keep working on the same
                                        // availability but we pass to the next
                                        // appointment
                                        // we go out of the while
                                        break;
                                    }
                                }
                                i++;

                            }
                            j++;

                        }
                        // add all free availability
                        for ( int z = i; z < availabilitys.size(); z++ ) {
                            availabilitys.get( z ).setDay( new MutableDateTime( startdDt ) );
                            avbs.addAvailabilitys( availabilitys.get( z ) );
                        }

                    }

                }
                startdDt.addDays( 1 );
                startdDt.setHourOfDay( 0 );

            }

            return Response.status( Response.Status.OK ).entity( avbs ).build();
        } catch ( Exception ex ) {

            logger.error( ex.getStackTrace()[0].getMethodName(), ex );
            return Response.serverError().entity( ex.getMessage() ).build();
        }
    }

    public DateTime addDay( String date, int nbDay ) {

        MutableDateTime startdDt = new MutableDateTime(
                DateTimeFormat.forPattern( "dd/MM/yyyy" ).parseDateTime( date.trim() ) );

        startdDt.addDays( nbDay );
        startdDt.setHourOfDay( 0 );

        return startdDt.toDateTime();
    }
}
