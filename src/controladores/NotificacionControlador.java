package controladores;

import java.util.ArrayList;
import java.util.List;

import logica.modelos.Notificacion;
import database.NotificacionDB;

public class NotificacionControlador {

	public void altaNotificacion(String content_name, String msg, String user_name){
		NotificacionDB ndb = NotificacionDB.getInstance();
		Notificacion not = new Notificacion(content_name, msg, user_name);
		ndb.altaNotificacion(not);
	}
	
	public void borrarNotificacion(int id){
		NotificacionDB ndb = NotificacionDB.getInstance();
		Notificacion not = getNotificacion(id);
		ndb.borrarNotificacion(not);
	}
	
	public void modificarNotificacion(Notificacion nueva_not){
		NotificacionDB ndb = NotificacionDB.getInstance();
		ndb.modificarNotificacion(nueva_not);
	}
	
	public Notificacion getNotificacion(int id){
		NotificacionDB ndb = NotificacionDB.getInstance();
		Notificacion not = ndb.getNotificacion(id);
		return not;
	}
	
	public List<Notificacion> getAllNotificaciones(String user_name){
		NotificacionDB ndb = NotificacionDB.getInstance();
		List<Notificacion> retlist = new ArrayList<Notificacion>();
		retlist = ndb.getAllNotificaciones(user_name);
		return retlist;
	}
}
