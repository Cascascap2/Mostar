package logica.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import database.Keys.CategoriasKey;

@Entity
@IdClass(CategoriasKey.class)
@Table(name="categorias_contenido")
public class Categorias_Contenido {
	
	@Id
	private String fk_contenido_name;
	
	@Id
	private String categoria_name;
	
	public Categorias_Contenido(){
	}
	
	public Categorias_Contenido(String fk_contenido_name, String categoria_name) {
		this.fk_contenido_name = fk_contenido_name;
		this.categoria_name = categoria_name;
	}
	
	public String getContenido_name() {
		return fk_contenido_name;
	}
	
	public void setContenido_name(String contenido_name) {
		this.fk_contenido_name = contenido_name;
	}
	
	public String getCategoria_name() {
		return categoria_name;
	}
	
	public void setCategoria_name(String categoria_name) {
		this.categoria_name = categoria_name;
	}

	
}
