package logica.eventos;

import java.util.Date;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import controladores.Manejador;
import controladores.NotificacionControlador;
import beans.notificacionesControlador;
import beans.userController;

//remove commons-email if not used

public class StreamAlert implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		String content_name = arg0.getJobDetail().getKey().getName();
		Manejador man = Manejador.getInstance();
		String user_name = man.getUser_nick();
		if(!user_name.equals("")){
			NotificacionControlador nc = man.getNotificacionControlador();
			String msg = "El evento " + content_name + " esta por comenzar";
			nc.altaNotificacion(content_name, msg, user_name);
		}
		else
			System.out.println("No hay usuario logueado");
	}
}
