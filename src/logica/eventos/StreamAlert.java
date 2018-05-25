package logica.eventos;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//remove commons-email if not used

public class StreamAlert implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Me disparo: " + new Date());
	
	}
}
