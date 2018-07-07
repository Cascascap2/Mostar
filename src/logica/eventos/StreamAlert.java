package logica.eventos;

import java.util.Date;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import controladores.Manejador;
import beans.notificacionesControlador;
import beans.userController;

//remove commons-email if not used

public class StreamAlert implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		String content_name = arg0.getJobDetail().getKey().getName();
		Manejador man = Manejador.getInstance();
		notificacionesControlador nbean = man.getNotificacionBean();
		String msg = "El evento " + content_name + " esta por comenzar";
		System.out.println("testenstreamalert");
		nbean.readyNotification(msg);
	}
}
