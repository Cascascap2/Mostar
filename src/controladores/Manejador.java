package controladores;

import java.util.List;

import beans.notificacionesControlador;
import beans.userController;
import logica.modelos.Categorias;

public class Manejador {

	private static Manejador instance = null;
	
	private List<Categorias> categorias;
	private userController sessionBean;
	private notificacionesControlador notificacionBean;

	
	protected Manejador() {
		CategoriaControlador cc = new CategoriaControlador();
		this.categorias = cc.getAllCategorias();
		this.notificacionBean = notificacionesControlador.getInstance();
	}

	public static Manejador getInstance() {
		if (instance == null) {
			instance = new Manejador();
		}
		return instance;
	}
	
	public List<Categorias> getCategorias(){
		return this.categorias;
	}
	
	public CategoriaControlador getCategoriaControlador(){
		return new CategoriaControlador();
	}
	
	public ContenidoControlador getContenidoControlador(){
		return new ContenidoControlador();
	}

	public UsuarioControlador getUsuarioControlador(){
		return new UsuarioControlador();
	}
	
	public ComentarioControlador getComentarioControlador(){
		return new ComentarioControlador();
	}

	public userController getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(userController sessionBean) {
		this.sessionBean = sessionBean;
	}

	public notificacionesControlador getNotificacionBean() {
		return notificacionBean;
	}

	public void setNotificacionBean(notificacionesControlador notificacionBean) {
		this.notificacionBean = notificacionBean;
	}
	
	
}
