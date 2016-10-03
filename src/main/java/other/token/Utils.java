package other.token;

import java.net.URI;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import model.custom.UserCustom;

public class Utils {
    private static Logger logger = Logger.getLogger( Utils.class );

    public static String getCookieValue( ContainerRequestContext request, String nom ) throws Exception {

        Map<String, Cookie> cookie = request.getCookies();

        String stringCookie = null;
        try {
            stringCookie = cookie.get( nom ).getValue();
        } catch ( Exception ex ) {
            logger.info( "no token with name=" + nom );
        }

        return stringCookie;

    }

    public static Response setCookie( String sujet, String valeur, long maxAge, Object objet,boolean seeOther ) {

        

        
        Cookie cookie = new Cookie( sujet, valeur, "/", null );
        if(seeOther)
         return Response.seeOther( (URI) objet ).cookie( new NewCookie( cookie, "Puls", (int) maxAge, false ) )
                .header( sujet, valeur ).build();
        
        return Response.ok( objet ).cookie( new NewCookie( cookie, "Puls", (int) maxAge, false ) )
                .header( sujet, valeur ).build();

    }

    /*
     * Format a Float or Double with local country format-->us=5.5 fr=5,5
     */
    public static String formatDecimalNumber( Object decimal, Locale local ) throws IllegalArgumentException {
        NumberFormat numberFormatter;

        numberFormatter = NumberFormat.getNumberInstance( local );

        String nombre = numberFormatter.format( decimal );

        return nombre;

    }

    public static String getValideServiceKeyCookie( ContainerRequestContext request, String nom, String ip )
            throws Exception {
        String token = getCookieValue( request, nom );
        if ( token == null || "".equals( token ) )
            return token;

        else if ( TokenBuilder.tokenServiceKeyIsValide( token, ip ) )
            return token;

        throw new Exception( "Token no available " );
    }

    public static boolean AuthTokenIsValide(UserCustom user, String token){
        if(user==null)
            return false;
                return    TokenBuilder.tokenAuthIsValide( token, user ); 
    }

    public static String getValideAuthTokenCookie( ContainerRequestContext request, String cookieName, UserCustom user )
            throws Exception {
        String token = getCookieValue( request, cookieName );
        if ( token == null || "".equals( token ) )
            return token;

        else if ( TokenBuilder.tokenAuthIsValide( token, user ) )
            return token;

        throw new Exception( "Token no available " );
    }

    /*
     * Format a Date with local country format
     */
    public String formatDate( Object date, Locale local ) throws IllegalArgumentException {

        DateFormat dateFormatter;

        dateFormatter = DateFormat.getDateInstance( DateFormat.DEFAULT, local );
        String dateOut = dateFormatter.format( date );
        return dateOut;
    }

    /*
     * Format a Date with local country format format with DateFormat.DEFAULT
     * ,DateFormat.WEEK_OF_YEAR_FIELD, etc..
     */
    public String formatDate( Object date, Locale local, int format ) throws IllegalArgumentException {

        DateFormat dateFormatter;

        dateFormatter = DateFormat.getDateInstance( format, local );
        String dateOut = dateFormatter.format( date );
        return dateOut;
    }

}
