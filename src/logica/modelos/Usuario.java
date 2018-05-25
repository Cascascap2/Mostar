package logica.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "mail")
	private String mail;

	@Column(name = "password")
	private String password;

	public Usuario() {

	}

	public Usuario(String nickname, String mail, String password) {
		this.nickname = nickname;
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nickname=" + nickname + ", mail=" + mail + ", password=" + password + "]";
	}
	
}
