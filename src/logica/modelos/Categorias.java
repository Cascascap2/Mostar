package logica.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column(name="categoria_name")
	private String categoria_name;
	
	public Categorias() {
	}
	
	public Categorias(String categoria_name) {
		this.categoria_name = categoria_name;
	}

	@Id
	public String getName() {
		return categoria_name;
	}
	
	public void setName(String name){
		this.categoria_name = name;
	}	
	

}
