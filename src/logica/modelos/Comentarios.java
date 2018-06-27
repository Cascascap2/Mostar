package logica.modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	private String contenido_name;	

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

	@Column(name="contenido_name")
	public String getContenido_name() {
		return contenido_name;
	}

	public void setContenido_name(String contenido_name) {
		this.contenido_name = contenido_name;
	}
	
	/*
	@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "comentario_usuario_spoilers",
            joinColumns = @JoinColumn(name = "fk_id_comentario"),
            inverseJoinColumns = @JoinColumn(name = "fk_user_name"))
	public List<Usuario> getSpoiler_givers() {
		return spoiler_givers;
	}

	public void setSpoiler_givers(List<Usuario> spoiler_givers) {
		this.spoiler_givers = spoiler_givers;
	}
*/
	
	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", User_nick=" + User_nick
				+ ", Message=" + Message + ", Spoiler=" + Spoiler
				+ ", contenido_name=" + contenido_name + "]";
	}

	public Comentarios(){
		
	}
	
	/*
	public void add_spoilerer(Usuario user){
		this.spoiler_givers.add(user);
	}
	*/
	
	public Comentarios(String user_nick, String msg, String Contenido_name) {
		this.User_nick = user_nick;
		this.Message = msg;
		this.Spoiler = 0;
		this.contenido_name = Contenido_name;		
	}
	
}
