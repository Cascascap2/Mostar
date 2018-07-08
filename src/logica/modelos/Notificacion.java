package logica.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notificaciones")
public class Notificacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String cont_name;
	private String msg;
	private String user_name;
	
	public Notificacion(String cont_name, String msg, String user_name) {
		this.cont_name = cont_name;
		this.msg = msg;
		this.user_name = user_name;
	}

	public Notificacion() {
		// TODO Auto-generated constructor stub
	}

	public String getCont_name() {
		return cont_name;
	}

	public void setCont_name(String cont_name) {
		this.cont_name = cont_name;
	}

	public int getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "Notificacion [id=" + id + ", cont_name=" + cont_name + ", msg="
				+ msg + ", user_name=" + user_name + "]";
	}
	
	
}
