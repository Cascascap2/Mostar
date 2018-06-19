package controladores;

import java.util.Set;

import logica.modelos.Categorias;
import logica.modelos.Contenido;
import daos.ContenidoDAO;

public class ContenidoControlador {

	public void altaContenido(String name, String empresa_name, String ruta, String descripcion, String tipo){
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido contenido = new Contenido(name, empresa_name, ruta, descripcion, tipo);
		cdao.altaContenido(contenido);
	}
	
	//modificiar

	public void borrarContenido(String name) {
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido tempUser = cdao.getContenido(name);
		cdao.borrarContenido(tempUser);				
	}

	//listar

	public Set<Categorias> getCategorias(String name){
		ContenidoDAO cdao = new ContenidoDAO();
		Set<Categorias> categorias = cdao.getCategorias(name);
		return categorias;
	}

	public Contenido getContenido(String name) {
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido user = cdao.getContenido(name);
		return user;
	}
	
	public void modificarContenido(Contenido con){
		ContenidoDAO cdao = new ContenidoDAO();
		cdao.modificarContenido(con);
	}

}
