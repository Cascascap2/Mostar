package logica.modelos;


import javax.persistence.Embeddable;
import javax.persistence.Entity;

import javax.persistence.Id;


@Embeddable
@Entity
public class Favorito {
	@Id
	int id;
	int contenido_id;
	int usuario_id;
	

	public Favorito(){
		
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getContenido_id() {
		return contenido_id;
	}



	public void setContenido_id(int contenido_id) {
		this.contenido_id = contenido_id;
	}



	public int getUsuario_id() {
		return usuario_id;
	}



	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}



	Favorito(int contenido){
		this.contenido_id = contenido;
	}
	
}
