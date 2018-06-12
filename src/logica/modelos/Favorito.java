package logica.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import database.FavoritesKey;

@Entity
@IdClass(FavoritesKey.class)
@Table(name="favoritos")
public class Favorito {

	@Id
	private String usuario_nick;
	@Id
	private String contenido_name;
	
	public Favorito() {
		
	}
	
	public Favorito(String user_id, String contenido_id) {
		this.usuario_nick = user_id;
		this.contenido_name = contenido_id;
	}

	public String getUsuario_nick() {
		return usuario_nick;
	}

	public void setUsuario_nick(String usuario_nick) {
		this.usuario_nick = usuario_nick;
	}

	public String getContenido_name() {
		return contenido_name;
	}

	public void setContenido_name(String contenido_name) {
		this.contenido_name = contenido_name;
	}
	
}
