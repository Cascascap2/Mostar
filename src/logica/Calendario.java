package logica;
import eventos.StreamAlert;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;




public class Calendario {
	
	public static void main(String[] args) throws SchedulerException{
		JobDetail evento = JobBuilder.newJob(StreamAlert.class).withIdentity("test").build();
		
		Date triggerTime = new Date();
		triggerTime.setHours(16);
		triggerTime.setMinutes(7);
		triggerTime.setSeconds(0);
		
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CroneTrigger2")
							.startAt(triggerTime).forJob("test").build();
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(evento, trigger);
	}
}
