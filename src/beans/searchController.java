package beans;

import java.util.List;


import controladores.ContenidoControlador;
import controladores.Manejador;
import logica.modelos.Contenido;

public class searchController{

	private List<Contenido> search_result;
	private String busqueda;
	private String categoria;
	private String search_msg;

	public List<Contenido> getSearch_result() {
		return search_result;
	}

	public void setSearch_result(List<Contenido> search_result) {
		this.search_result = search_result;
	}
	
	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}
	
	 public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getSearch_msg() {
		return search_msg;
	}

	public void setSearch_msg(String search_msg) {
		this.search_msg = search_msg;
	}

	public String buscarCategoria(){
		this.search_msg = "Buscando por categoria: " + this.categoria;
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		this.search_result = cc.buscar_por_categoria(this.categoria);
		this.busqueda = "";
		return "searchResult";
	}
	
	public String busquedaGeneral(){
		this.search_msg = "Buscando por palabra: " + this.busqueda;
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		this.search_result = cc.buscar_por_chars_al_comienzo(this.busqueda);
		this.busqueda = "";
		return "searchResult";
	}
		
}
