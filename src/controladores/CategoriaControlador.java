package controladores;

import java.util.List;
import java.util.Set;

import daos.CategoriaDAO;
import logica.modelos.Categorias;

public class CategoriaControlador {
	
	public void altaCategoria(String categoria_name){
		Categorias c = new Categorias(categoria_name);
		CategoriaDAO cdao = new CategoriaDAO();
		cdao.altaCategoria(c);		
	}

	public void deleteCategoria(Categorias c){
		CategoriaDAO cdao = new CategoriaDAO();
		cdao.deleteCategoria(c);
	}

	public List<Categorias> getAllCategorias(){
		CategoriaDAO cdao = new CategoriaDAO();
		return cdao.getAllCategorias();
	}
}
