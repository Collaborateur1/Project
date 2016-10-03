package scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ScheduleTask extends QuartzJobBean {

    @Override
    protected void executeInternal( JobExecutionContext arg0 ) throws JobExecutionException {
        // TODO Auto-generated method stub
        // System.out.println( "hahaha sa marche..." );
    }

}
