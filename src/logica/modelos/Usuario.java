package logica.modelos;


import java.util.ArrayList;
import java.util.Date;



import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	private boolean activo;
	
	private String empresa_nombre;
	
	private List<Comentarios> dados_spoiler;
	
	
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
		this.activo = true;
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

	
	@OneToMany(fetch = FetchType.EAGER)
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
	

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	public String getEmpresa_nombre() {
		return empresa_nombre;
	}

	public void setEmpresa_nombre(String empresa_nombre) {
		this.empresa_nombre = empresa_nombre;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "comentario_usuario_spoilers",
            joinColumns = @JoinColumn(name = "fk_user_name"),
            inverseJoinColumns = @JoinColumn(name = "fk_id_comentario"))
	public List<Comentarios> getDados_spoiler() {
		return dados_spoiler;
	}

	public void setDados_spoiler(List<Comentarios> dados_spoiler) {
		this.dados_spoiler = dados_spoiler;
	}
	
	public void addSpoileredComment(Comentarios com){
		this.dados_spoiler.add(com);
	}

	@Override
	public String toString() {
		return "Usuario [nickname=" + nickname + ", mail=" + mail
				+ ", password=" + password + ", favorites=" + favorites
				+ ", wallet=" + wallet + ", DateExpiration=" + DateExpiration
				+ ", PermissionId=" + PermissionId + ", activo=" + activo
				+ ", empresa_nombre=" + empresa_nombre + "]";
	}

	@Transient
	public List<Contenido> getFavoritesInList() {
		List<Contenido> ret = new ArrayList<Contenido>();
		Iterator<Contenido> it = this.favorites.iterator();
		Contenido con = new Contenido();
		while(it.hasNext()){
			con = (Contenido) it.next();
			ret.add(con);
		}
		return ret;
	}
	
}
