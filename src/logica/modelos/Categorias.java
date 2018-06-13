package logica.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias {
	
	@Column(name="categoria_name")
	private String categoria_name;
	
	public Categorias() {
	}
	
	@Id
	public String getName() {
		return categoria_name;
	}
	
	public void setName(String name){
		this.categoria_name = name;
	}	
	

}
