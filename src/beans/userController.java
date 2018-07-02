package beans;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import controladores.ContenidoControlador;
import controladores.Manejador;
import controladores.UsuarioControlador;
import logica.modelos.Contenido;
import logica.modelos.Usuario;

import org.primefaces.push.annotation.Singleton;

@Singleton
public class userController {
	public static final String AUTH_KEY = "app.user.name";
	public static final String PERMISSION_KEY = "app.user.permission";

	private String nickname;

	private String mail;

	private String password;

	private Set<Contenido> favorites;

	private Double wallet;
	
	private Double saldoRecarga = 0.0;
	
	private Date DateExpiration;

	private int PermissionId;

	private boolean Logged;

	private String massages;
	
	private int numeroTarj=0;
	
	private Date fechTarjExp;
	
	private int numeroVer;
	
	private String msg;
	
	private boolean suscrito;
	


	public int getNumeroTarj() {
		return numeroTarj;
	}



	public void setNumeroTarj(int numeroTarj) {
		this.numeroTarj = numeroTarj;
	}



	public Date getFechTarjExp() {
		return fechTarjExp;
	}



	public void setFechTarjExp(Date fechTarjExp) {
		this.fechTarjExp = fechTarjExp;
	}



	public int getNumeroVer() {
		return numeroVer;
	}



	public void setNumeroVer(int numeroVer) {
		this.numeroVer = numeroVer;
	}



	public Double getSaldoRecarga() {
		return saldoRecarga;
	}



	public void setSaldoRecarga(Double saldoRecarga) {
		this.saldoRecarga = saldoRecarga;
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

	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuscrito() {
		return suscrito;
	}

	public void setSuscrito(boolean suscrito) {
		this.suscrito = suscrito;
	}

	@Override
	public String toString() {
		return "userController [nickname=" + nickname + ", mail=" + mail + ", password=" + password + ", favorites="
				+ favorites + ", wallet=" + wallet + ", DateExpiration=" + DateExpiration + ", PermissionId="
				+ PermissionId + ", Logged=" + Logged + ", massages=" + massages + "]";
	}

	public void debug() {
		java.lang.System.out.println(this.toString());
	}
	public String rechargeWallet(){
		Manejador man = Manejador.getInstance();
		System.out.println("manejador");
		Usuario user = man.getUsuarioControlador().getUsuario(nickname);
		System.out.println("Saldo rec:"+this.saldoRecarga.toString());
		System.out.println("Saldo:"+this.wallet.toString());
		user.setWallet(this.saldoRecarga + this.wallet);
		System.out.println("suma saldo");
		man.getUsuarioControlador().modificarUsuario(user);
		this.wallet = user.getWallet();
		System.out.println("Usuario modificado corredctamente");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Info","Recarga realizada con exito!") );
		return "billetera";
		
	}
	
	public void validateNick(){
		Manejador man = Manejador.getInstance();
		Usuario user = man.getUsuarioControlador().getUsuario(this.nickname);
		if(user == null){
			this.massages ="Valido";
		}else {
			this.massages = "Invalido";
		}
		
	}
	
	public String recargar() {
		return "recarga";
	} 

	public String login() {
		Usuario NewUser = new Usuario();
		Manejador man = Manejador.getInstance();
		UsuarioControlador controllerUser = man.getUsuarioControlador();
		if (mail != null) {
			NewUser = controllerUser.getUsuarioPorMail(mail);
			if (NewUser != null) {
				if (NewUser.getPassword().equals(password)){
					if(NewUser.isActivo()) {
						this.setMassages("Usuario Logueado Correctamente...");
						this.PermissionId = NewUser.getPermissionId();
						this.nickname = NewUser.getNickname();
						this.wallet = NewUser.getWallet();
						this.favorites = NewUser.getFavorites();
						this.Logged = true;
						FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, nickname);
						FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(PERMISSION_KEY, (Integer)PermissionId);
						return "home";
					}else {
						this.massages = "Usuario Inactivo";
						return "login";
					}
					this.suscrito = checkSuscription(NewUser);
				}else {
					this.massages="Contraseña incorrecta ...";
					this.Logged = false;
					return "login";
				}
			} else {
				this.massages ="Mail invalido ...";
				System.out.println("No encuentro usuario por mail");
				this.Logged = false;
				return "login";
			}

		} else {
			this.massages="El mail no debe ser vacio...";
			System.out.println("no encuentro usuario por mail");
			this.Logged = false;
			return "login";
		}
	}
	
	public boolean checkSuscription(Usuario user) {
		Date expDate = user.getDateExpiration();
		Date currentDate = new Date();
		if(currentDate.getYear() <= expDate.getYear())
			if(currentDate.getMonth() <= expDate.getMonth())
				if(currentDate.getDay() <= expDate.getDay())
					return true;
		return false;
	}
	
	public String cerrarSession(){
		java.lang.System.out.println("logged out");		
		Manejador man = Manejador.getInstance();
		man.setSessionBean(null);
		this.nickname = null;
		this.mail = null;
		this.password = null;
		this.favorites = null;
		this.wallet = null;
		this.DateExpiration = null;
		this.PermissionId = 0;
		this.Logged = false;
		this.massages = "Usuario deslogueado correctamente";
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_KEY);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(PERMISSION_KEY);
		return "home";
	}

	public boolean isLoggedIn() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(AUTH_KEY) != null;
	}
	
	public void updateFavoritos(){
		Manejador man = Manejador.getInstance();
		UsuarioControlador controllerUser = man.getUsuarioControlador();
		Usuario NewUser = controllerUser.getUsuarioPorMail(this.mail);
		this.favorites = NewUser.getFavorites();
	}
	
	public void testAviso(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador(); 
		Contenido con2 = cc.getContenido("StreamTest");
		System.out.println("Test get");
		
		int hour 	= 01;
		int minutes = 40;
		int seconds = 00;
		
		Calendar triggerTime = Calendar.getInstance();
		triggerTime.set(Calendar.HOUR, hour);
		triggerTime.set(Calendar.MINUTE, minutes);
		triggerTime.set(Calendar.SECOND, seconds);		
		
		cc.programar_stream(con2, triggerTime.getTime());
		System.out.println(triggerTime.getTime().toString());
		System.out.println("Test end");
	}
	
	public void testTrigger(){
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("test: " + this.msg);
		context.addMessage(null, new FacesMessage("Evento", "testing the testing test for the tester"));
		System.out.println("Why don't i execute?");
	}
	
	public void cambiarPassword(){
		Manejador man = Manejador.getInstance();
		UsuarioControlador uc = man.getUsuarioControlador();
		Usuario user = uc.getUsuario(this.nickname);
		user.setPassword(this.password);
		uc.modificarUsuario(user);
		FacesContext context = FacesContext.getCurrentInstance();
	    context.addMessage(null, new FacesMessage("Exito",  "La password fue cambiada") );
	}

}
