package daos;

import java.util.List;
import java.util.Set;

import database.CategoriaDB;
import logica.modelos.Categorias;

public class CategoriaDAO {

	public void altaCategoria(Categorias c){
		CategoriaDB cdb = CategoriaDB.getInstance();
		cdb.altaCategoria(c);
	}
	
	public void deleteCategoria(Categorias c){
		CategoriaDB cdb = CategoriaDB.getInstance();
		cdb.deleteCategoria(c);
	}

	public List<Categorias> getAllCategorias(){
		CategoriaDB cdb = CategoriaDB.getInstance();
		return cdb.getAllCategorias();
	}

	
}
