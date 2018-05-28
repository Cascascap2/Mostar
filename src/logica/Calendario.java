package logica;
import logica.eventos.StreamAlert;

import java.util.Calendar;

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
		
		
		int hour 	= 02;
		int minutes = 12;
		int seconds = 00;
		
		Calendar triggerTime = Calendar.getInstance();
		triggerTime.set(Calendar.HOUR, hour);
		triggerTime.set(Calendar.MINUTE, minutes);
		triggerTime.set(Calendar.SECOND, seconds);
		
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CroneTrigger2")
							.startAt(triggerTime.getTime()).forJob("test").build();
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(evento, trigger);
	}
}
