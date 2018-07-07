package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import logica.modelos.Contenido;
import logica.modelos.Notificacion;

import org.primefaces.push.annotation.Singleton;

import controladores.ContenidoControlador;
import controladores.Manejador;
import controladores.NotificacionControlador;

@Singleton
public class notificacionesControlador {
	private String msg;
	private static notificacionesControlador instance = null;
	
	public notificacionesControlador() {
		
	}
	
	public static notificacionesControlador getInstance() {
      if(instance == null) {
         instance = new notificacionesControlador();
      }
      return instance;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@PostConstruct
	public void init(){
		this.msg = "";
	}
		
	public void mostrarNotificacion(){
		Manejador man = Manejador.getInstance();
		String user_name = man.getUser_nick();
		if(!user_name.equals("")){
			NotificacionControlador nc = man.getNotificacionControlador();
			List<Notificacion> notificaciones = new ArrayList<Notificacion>();
			notificaciones = nc.getAllNotificaciones(user_name);
			if(notificaciones.size()!= 0){
				Iterator<Notificacion> it = notificaciones.iterator();
				Notificacion not = new Notificacion();
				Contenido con = new Contenido();
				String con_name;
				ContenidoControlador cc = man.getContenidoControlador();
				while(it.hasNext()){
					not = (Notificacion) it.next();
					con_name = not.getCont_name();
					con = cc.getContenido(con_name);
					if(cc.usuarioPermitido(user_name, con)){
						this.msg = not.getMsg();
						nc.borrarNotificacion(not.getId());
					}						
				}
				if(!this.msg.equals("")){
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Evento",  this.msg));
					this.msg="";
				}
			}
			else
				System.out.println("No hay notificaciones");
		}
		else
			System.out.println("No hay un usuario logueado al que notificar");
	}
		
}
