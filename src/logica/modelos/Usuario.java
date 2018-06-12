package logica.modelos;


import java.util.Date;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "usuarios")
public class Usuario {
	private String nickname;

	private String mail;

	private String password;
	
	private Set<Contenido> favorites;
	
	private Double wallet;

	private Date DateExpiration;
	
	private int PermissionId;
	
	
	public Usuario() {
		this.favorites = new HashSet<Contenido>();
	}

	public Usuario(String nickname, String mail, String password,
					Double wallet, Date expiration, int permission) {
		this.nickname = nickname;
		this.mail = mail;
		this.password = password;
		this.wallet = wallet;
		this.DateExpiration = expiration;
		this.PermissionId = permission;
		this.favorites = new HashSet<Contenido>();
	}
	
	@Column(name= "permission_id")
	public int getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(int permissionId) {
		PermissionId = permissionId;
	}
	
	@Id
    @Column(name = "nickname")
	//@NaturalId
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

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "favoritos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "contenido_id"))
	public Set<Contenido> getFavorites() {
		return this.favorites;
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

	@Column(name= "date_expiration")
	public Date getDateExpiration() {
		return DateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		DateExpiration = dateExpiration;
	}
	
	public void addFavorito(Contenido con) {
		this.favorites.add(con);
	}
	

	@Override
	public String toString() {
		return "Usuario [id=" + ", nickname=" + nickname + ", mail=" + mail + ", password=" + password + "]";
	}
	
}
