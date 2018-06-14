package controladores;

import java.util.Set;

import logica.modelos.Categorias;

//TODO crear CategoriasDB, DAO y controlador, cargar las categorias al crear manejador
public class Manejador {

	private static Manejador instance = null;
	
	private Set<Categorias> categorias;

	
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
