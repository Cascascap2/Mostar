package beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import controladores.Manejador;
import controladores.UsuarioControlador;
import logica.modelos.Usuario;

public class registerController{
	
	private String nickname;
	private String mail;
	private String password;
	private String repeatPassword;
	private String Messages;	
	
	public String getMessages() {
		return Messages;
	}

	public void setMessages(String messages) {
		Messages = messages;
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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public boolean validateNick() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario NewUser = new Usuario();
		Manejador man = Manejador.getInstance(); 
		UsuarioControlador controllerUser = man.getUsuarioControlador();
		if(nickname != null) {
			NewUser = controllerUser.getUsuario(nickname);
			if(NewUser!= null) {
				this.setMessages("El Nickname ya exisite.");
				context.addMessage(null, new FacesMessage("Info", this.Messages));
				return false;
			}else {
				this.setMessages("Nickname Valido.");
				context.addMessage(null, new FacesMessage("Info", this.Messages));
				return true;
			}
		}else {
			this.setMessages("El Nickname no debe ser vacio.");
			context.addMessage(null, new FacesMessage("Info", this.Messages));
			return false;
		}
	}
	
	public boolean validateMail () {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario NewUser = new Usuario();
		Manejador man = Manejador.getInstance(); 
		UsuarioControlador controllerUser = man.getUsuarioControlador();
		if(mail != null) {
			NewUser = controllerUser.getUsuarioPorMail(mail);
			if(NewUser!= null) {
				this.setMessages("Ya existe usuario registrado con ese mail .");
				context.addMessage(null, new FacesMessage("Info", this.Messages));
				return false;
			}else {
				this.setMessages("Mail valido.");
				context.addMessage(null, new FacesMessage("Info", this.Messages));
				return true;	
			}
		}else {
			this.setMessages("El Mail no debe ser vacio.");
			context.addMessage(null, new FacesMessage("Info", this.Messages));
			return false;
		}
	}
	
	public boolean validatePassword (){
		FacesContext context = FacesContext.getCurrentInstance();
		if(password != null && password.length() >= 8) {
			if(this.repeatPassword.equals(password)) {
				this.setMessages("Contraseña valida.");
				context.addMessage(null, new FacesMessage("Info", this.Messages));
				return true;
			}
			else {
				this.setMessages("Las Contraseñas deben ser iguales.");
				context.addMessage(null, new FacesMessage("Info", this.Messages));
				return false;
			}
			
		}else{
			this.setMessages("Contraseña invalida debe contener al menos 8 caracteres.");
			context.addMessage(null, new FacesMessage("Info", this.Messages));
			return false;
		}
			
	}
	
	public String registerUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(validateNick() && validateMail() && validatePassword()){
			Manejador man = Manejador.getInstance(); 
			UsuarioControlador controllerUser = man.getUsuarioControlador();
			controllerUser.registrarUsuario(nickname, mail, password, 0.0,new Date(),1);
			context.addMessage(null, new FacesMessage("Info", this.Messages));
			return "home";
		}
		else {
			context.addMessage(null, new FacesMessage("Info", this.Messages));
			return "register";
		}
	}
}
