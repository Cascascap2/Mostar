package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import controladores.ContenidoControlador;
import controladores.Manejador;
import logica.modelos.Contenido;

public class homeController {

	private static final int ESTRENOS = 4;
	
	private String test;
	private List<Contenido> contenidos;
	private List<Contenido> peliculas;
	private List<Contenido> ultimas_peliculas;
	private List<Contenido> eventos;
	
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


	public List<Contenido> getUltimas_pelicula() {
		return ultimas_peliculas;
	}


	public void setUltimas_pelicula(List<Contenido> ultimas_pelicula) {
		this.ultimas_peliculas = ultimas_pelicula;
	}


	public List<Contenido> getPeliculas() {
		return peliculas;
	}
	
	public void setPeliculas(List<Contenido> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Contenido> getUltimas_peliculas() {
		return ultimas_peliculas;
	}


	public void setUltimas_peliculas(List<Contenido> ultimas_peliculas) {
		this.ultimas_peliculas = ultimas_peliculas;
	}


	public List<Contenido> getEventos() {
		return eventos;
	}


	public void setEventos(List<Contenido> eventos) {
		this.eventos = eventos;
	}


	public static int getEstrenos() {
		return ESTRENOS;
	}


	@PostConstruct
	public void init(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		this.contenidos = cc.getAllContenido();
		this.peliculas = new ArrayList();
		this.ultimas_peliculas = new ArrayList();
		this.eventos = new ArrayList();
		List<Contenido> ultimas = new ArrayList();
		Iterator it = this.contenidos.iterator();
		Contenido con;
		Iterator it2 = ultimas.iterator();
		while(it.hasNext()){
			con = (Contenido) it.next();
			if(con.getTipo().equals("Pelicula")){
				this.peliculas.add(con);
				if(ultimas.size()<ESTRENOS){
					ultimas.add(con);
				}
				else{
					ultimas.remove(0);
					ultimas.add(con);
				}
			}
			else if(con.getTipo().equals("Evento"))
				this.eventos.add(con);
		}	
		this.ultimas_peliculas = ultimas;	
	}
	
}
