package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import controladores.ComentarioControlador;
import controladores.ContenidoControlador;
import controladores.Manejador;
import logica.modelos.Contenido;

public class homeController {

	private String test;
	private List<Contenido> contenidos;
	private List<Contenido> ultimos_contenidos;
	private List<Contenido> peliculas;
	
	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}



	public List<Contenido> getContenidos() {
		return contenidos;
	}



	public void setContenidos(List<Contenido> contenidos) {
		this.contenidos = contenidos;
	}



	public List<Contenido> getUltimos_contenidos() {
		return ultimos_contenidos;
	}



	public void setUltimos_contenidos(List<Contenido> ultimos_contenidos) {
		this.ultimos_contenidos = ultimos_contenidos;
	}


	public List<Contenido> getPeliculas() {
		return peliculas;
	}
	
	public void setPeliculas(List<Contenido> peliculas) {
		this.peliculas = peliculas;
	}


	@PostConstruct
	public void init(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		this.contenidos = cc.getAllContenido();
		this.peliculas = new ArrayList();
		Iterator it = this.contenidos.iterator();
		Contenido con;
		while(it.hasNext()){
			con = (Contenido) it.next();
			if(con.getTipo().equals("Pelicula"))
				this.peliculas.add(con);
		}
		java.lang.System.out.println(this.contenidos.size());
	}
	
}
