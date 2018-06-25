package beans;

import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import logica.modelos.Comentarios;
import logica.modelos.Contenido;
import controladores.ComentarioControlador;
import controladores.ContenidoControlador;
import controladores.Manejador;

public class videoController {
	
	private String contenido_name;
	private String provider_name;
	private String ruta;
	private int vistas;
	private double calificacion;
	private String descripcion;
	private String ruta_imagen;
	private List<Comentarios> comentarios;

	
	public String getContenido_name() {
		return contenido_name;
	}
	public void setContenido_name(String contenido_name) {
		this.contenido_name = contenido_name;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public int getVistas() {
		return vistas;
	}
	public void setVistas(int vistas) {
		this.vistas = vistas;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}
	

	@Override
	public String toString() {
		return "videoController [contenido_name=" + contenido_name
				+ ", provider_name=" + provider_name + ", ruta=" + ruta
				+ ", vistas=" + vistas + ", calificacion=" + calificacion
				+ ", descripcion=" + descripcion + "]";
	}
	
	public void getPeliculaElejida(ActionEvent event){
		this.contenido_name = (String)event.getComponent().getAttributes().get("pelicula_elejida");
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		Contenido con = cc.getContenido(contenido_name);
		ComentarioControlador coc = man.getComentarioControlador();
		this.comentarios = coc.getAllComentariosByContName(contenido_name);
		java.lang.System.out.println("Comentarios: " + this.comentarios.size());
		this.ruta = con.getRuta();	
	}
	
	public String verPelicula(){
		return "verVideo";
	}
	
	
	
}
