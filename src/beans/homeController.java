package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import controladores.CategoriaControlador;
import controladores.ContenidoControlador;
import controladores.Manejador;
import logica.modelos.Categorias;
import logica.modelos.Contenido;

public class homeController implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final int ESTRENOS = 4;
	
	private String test;
	private List<Contenido> contenidos;
	private List<Contenido> peliculas;
	private List<Contenido> ultimas_peliculas;
	private List<Contenido> eventos;
	private List<String> categorias;
	
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

	public List<String> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}


	@PostConstruct
	public void init(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		CategoriaControlador cac = man.getCategoriaControlador();
		this.contenidos = cc.getAllContenido();
		this.peliculas = new ArrayList<Contenido>();
		this.ultimas_peliculas = new ArrayList<Contenido>();
		this.eventos = new ArrayList<Contenido>();
		this.categorias = new ArrayList<String>();
		List<Categorias> cats = cac.getAllCategorias();
		List<Contenido> ultimas = new ArrayList<Contenido>();
		Iterator<Contenido> it = this.contenidos.iterator();
		Iterator<Categorias> it2 = cats.iterator();
		Contenido con;
		Categorias cat;
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
		while(it2.hasNext()){
			cat = (Categorias) it2.next();
			this.categorias.add(cat.getName());
		}
		this.ultimas_peliculas = ultimas;	
	}
	
	public String goHome(){
		return "home";
	}
	
	public String contentDateToString(Contenido con){
		return con.getHora_streaming().toString();
	}
	
	public String verStream(){
		return "streaming";
	}
}
