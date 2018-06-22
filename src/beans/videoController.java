package beans;

import java.util.List;


import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import logica.modelos.Comentarios;
import controladores.ComentarioControlador;
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
	
	@PostConstruct
	public void init(){
		Manejador man = Manejador.getInstance();
		ComentarioControlador cc = man.getComentarioControlador();
		this.comentarios = cc.getAllComentariosByContName(this.contenido_name);
		//java.lang.System.out.println("Comments: " + this.comentarios.size());
	}
	
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
	
	@Override
	public String toString() {
		return "videoController [contenido_name=" + contenido_name
				+ ", provider_name=" + provider_name + ", ruta=" + ruta
				+ ", vistas=" + vistas + ", calificacion=" + calificacion
				+ ", descripcion=" + descripcion + "]";
	}
	
	
	public String verPelicula(){
		System.out.println(this.ruta_imagen);
		return "verVideo";
	}
	
}
