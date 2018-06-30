package daos;

import java.util.List;

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

	public Categorias getCategoria(String cat_name) {
		CategoriaDB cdb = CategoriaDB.getInstance();
		return cdb.getCategoria(cat_name);
	}

	
}
