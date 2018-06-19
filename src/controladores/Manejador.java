package controladores;

import java.util.List;
import java.util.Set;

import logica.modelos.Categorias;

public class Manejador {

	private static Manejador instance = null;
	
	private List<Categorias> categorias;

	
	protected Manejador() {
		CategoriaControlador cc = new CategoriaControlador();
		this.categorias = cc.getAllCategorias();
	}

	public static Manejador getInstance() {
		if (instance == null) {
			instance = new Manejador();
		}
		return instance;
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
}
