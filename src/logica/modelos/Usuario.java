package logica.modelos;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	private int id;

	@NaturalId
	private String nickname;

	private String mail;

	private String password;
	
	private ArrayList<Integer> favorites;
	
	private Float wallet;
	
	private Date DateExpiration;
	
	private int PermissionId;
	
	
	

	public int getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(int permissionId) {
		PermissionId = permissionId;
	}

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
	

	
	public ArrayList<Integer> getFavorites() {
		return favorites;
	}

	public void setFavorites(ArrayList<Integer> favorites) {
		this.favorites = favorites;
	}

	public Float getWallet() {
		return wallet;
	}

	public void setWallet(Float wallet) {
		this.wallet = wallet;
	}

	public Date getDateExpiration() {
		return DateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		DateExpiration = dateExpiration;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nickname=" + nickname + ", mail=" + mail + ", password=" + password + "]";
	}
	
}
