package daos;

import java.util.Set;

import database.ContenidoDB;
import logica.modelos.Categorias;
import logica.modelos.Contenido;

public class ContenidoDAO {

	public void altaContenido(Contenido tempUser) {
		ContenidoDB cdb = ContenidoDB.getInstance();
		cdb.altaContenido(tempUser);		
	}
	
	
	//crear
	//modificar
	
	public void borrarContenido(Contenido contenido_name) {
		ContenidoDB cdb = ContenidoDB.getInstance();
		cdb.borrarContenido(contenido_name);
	}
	
	//listar
	
	public Contenido getContenido(String con_name) {
		ContenidoDB cdb = ContenidoDB.getInstance();
		Contenido tempUser = cdb.getContenido(con_name);
		return tempUser;
	}
	
	public Set<Categorias> getCategorias(String cat_name){
		ContenidoDB cdb = ContenidoDB.getInstance();
		Set<Categorias> categorias = cdb.getCategorias(cat_name);
		return categorias;
	}


	public void modificarContenido(Contenido con) {
		ContenidoDB cdb = ContenidoDB.getInstance();
		cdb.modificarContenido(con);
	}

}
