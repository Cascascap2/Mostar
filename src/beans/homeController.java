package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import controladores.ContenidoControlador;
import controladores.Manejador;
import logica.modelos.Contenido;

public class homeController {

	private static final int ESTRENOS = 3;
	
	private String test;
	private List<Contenido> contenidos;
	private List<Contenido> peliculas;
	private List<Contenido> ultimas_peliculas;
	
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


	@PostConstruct
	public void init(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		this.contenidos = cc.getAllContenido();
		this.peliculas = new ArrayList();
		this.ultimas_peliculas = new ArrayList();
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
		}
		java.lang.System.out.println(this.contenidos.size());
		java.lang.System.out.println("Ultimos contenidos:");
		this.ultimas_peliculas = ultimas;
		Iterator it3 = this.ultimas_peliculas.iterator();
		while(it3.hasNext()){
			Contenido con3 = (Contenido) it3.next();
			java.lang.System.out.println(con3.getName());
		}
		
	}
	
}
