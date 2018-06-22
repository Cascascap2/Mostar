package beans;

import java.util.Date;
import java.util.Set;

import controladores.Manejador;
import controladores.UsuarioControlador;
import logica.modelos.Contenido;
import logica.modelos.Usuario;

import org.primefaces.push.annotation.Singleton;

@Singleton
public class userController {
	
	private String nickname;

	private String mail;

	private String password;
	
	private Set<Contenido> favorites;
	
	private Double wallet;

	private Date DateExpiration;
	
	private int PermissionId;
	
	private boolean Logged;
	
	private String massages;
	
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
	public int getPermissionId() {
		return PermissionId;
	}
	public void setPermissionId(int permissionId) {
		PermissionId = permissionId;
	}
	public boolean isLogged() {
		return Logged;
	}
	public void setLogged(boolean Logged) {
		this.Logged = Logged;
	}
	public String getMassages() {
		return massages;
	}
	public void setMassages(String massages) {
		this.massages = massages;
	}
	
	@Override
	public String toString() {
		return "userController [nickname=" + nickname + ", mail=" + mail
				+ ", password=" + password + ", favorites=" + favorites
				+ ", wallet=" + wallet + ", DateExpiration=" + DateExpiration
				+ ", PermissionId=" + PermissionId + ", Logged=" + Logged
				+ ", massages=" + massages + "]";
	}
	
	public void debug(){
		java.lang.System.out.println(this.toString());
	}
	
	public String login(){
		Usuario NewUser = new Usuario();
		Manejador man = Manejador.getInstance(); 
		UsuarioControlador controllerUser = man.getUsuarioControlador();
		if(mail != null) {
			NewUser = controllerUser.getUsuarioPorMail(mail);
			if(NewUser!= null) {
				if(NewUser.getPassword().equals(password)) {
					this.setMassages("Usuario Logueado Correctamente...");					
					this.PermissionId = NewUser.getPermissionId();
					this.nickname = NewUser.getNickname();
					this.wallet = NewUser.getWallet();
					this.favorites = NewUser.getFavorites();
					this.Logged = true;
					return "home";
				}else {
					this.setMassages("Contraseña incorrecta ...");
					this.Logged = false;
					return "login";	
				}
			}else {
				this.setMassages("Mail invalido ...");
				this.Logged = false;
				return "login";	
			}
			
		}else {
			this.setMassages("El mail no debe ser vacio...");
			this.Logged = false;
			return "login";	
		}
	}
	
	public String cerrarSession(){
		java.lang.System.out.println("logged out");		
		this.nickname = null;
		this.mail = null;
		this.password = null;
		this.favorites = null;
		this.wallet = null;
		this.DateExpiration = null;
		this.PermissionId = 0;
		this.Logged = false;
		this.massages = "Usuario deslogueado correctamente";		
		return "home";
	}
	
	
}
