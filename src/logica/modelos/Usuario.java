package logica.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	private Set<Contenido> favorites;
	
	private Double wallet;

	@Column(name= "date_expiration")
	private Date DateExpiration;
	
	@Column(name= "permission_id")
	private int PermissionId;
	
	
	public int getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(int permissionId) {
		PermissionId = permissionId;
	}

	public Usuario() {

	}

	public Usuario(String nickname, String mail, String password,
					Double wallet, Date expiration, int permission) {
		this.nickname = nickname;
		this.mail = mail;
		this.password = password;
		this.wallet = wallet;
		this.DateExpiration = expiration;
		this.PermissionId = permission;
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

	public Set<Contenido> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<Contenido> favorites) {
		this.favorites = favorites;
	}
	
	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
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
