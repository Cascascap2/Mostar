package logica.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comentarios")
public class Comentarios {
	@Id
	private int id;
	@Column(name="user_nick")
	private String User_nick;
	@Column(name="message")
	private String Message;
	@Column(name="spoiler")
	private int Spoiler;
	@Column(name="contenido_name")
	private String Contenido_name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_nick() {
		return User_nick;
	}

	public void setUser_nick(String user_nick) {
		User_nick = user_nick;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getSpoiler() {
		return Spoiler;
	}

	public void setSpoiler(int spoiler) {
		Spoiler = spoiler;
	}

	public String getContenidoId() {
		return Contenido_name;
	}

	public void setContenidoId(String contenidoId) {
		Contenido_name = contenidoId;
	}

	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", User_nick=" + User_nick + ", Message=" + Message + ", Spoiler=" + Spoiler
				+ ", ContenidoId=" + Contenido_name + "]";
	}
	
	public Comentarios(){
		
	}
	
	public Comentarios(String user_nick, String msg, String Contenido_name) {
		this.User_nick = user_nick;
		this.Message = msg;
		this.Spoiler = 0;
		this.Contenido_name = Contenido_name;		
	}
	
	
}
