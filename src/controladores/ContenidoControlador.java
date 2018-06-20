package controladores;

import java.util.Date;
import java.util.Set;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import logica.eventos.StreamAlert;
import logica.modelos.Categorias;
import logica.modelos.Contenido;
import daos.ContenidoDAO;

public class ContenidoControlador {

	public void altaContenido(String name, String empresa_name, String ruta, String descripcion, String tipo){
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido contenido = new Contenido(name, empresa_name, ruta, descripcion, tipo);
		cdao.altaContenido(contenido);
	}
	
	//modificiar

	public void borrarContenido(String name) {
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido tempUser = cdao.getContenido(name);
		cdao.borrarContenido(tempUser);				
	}

	//listar

	public Set<Categorias> getCategorias(String name){
		ContenidoDAO cdao = new ContenidoDAO();
		Set<Categorias> categorias = cdao.getCategorias(name);
		return categorias;
	}

	public Contenido getContenido(String name) {
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido user = cdao.getContenido(name);
		return user;
	}
	
	public void modificarContenido(Contenido con){
		ContenidoDAO cdao = new ContenidoDAO();
		cdao.modificarContenido(con);
	}
	
	public void programar_stream(Contenido con, Date hora_de_comienzo){
		if(con.getTipo().equals("Evento")){
			ContenidoDAO cdao = new ContenidoDAO();
			con.setHora_streaming(hora_de_comienzo);
			cdao.modificarContenido(con);
			
			
			JobDetail evento = JobBuilder.newJob(StreamAlert.class).withIdentity(con.getName()).build();
			
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CroneTrigger2")
								.startAt(hora_de_comienzo).forJob(con.getName()).build();
			
			try {
				Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
				scheduler.start();
				scheduler.scheduleJob(evento, trigger);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("El contenido no es un stream y no es programable.");
	}

}
