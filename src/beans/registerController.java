package beans;

import java.util.Date;



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

	public void validateNick() {
		Usuario NewUser = new Usuario();
		Manejador man = Manejador.getInstance(); 
		UsuarioControlador controllerUser = man.getUsuarioControlador();
		if(nickname != null) {
			NewUser = controllerUser.getUsuario(nickname);
			if(NewUser!= null) {
				this.setMessages("El Nickname ya exisite.");
			}else {
				this.setMessages("Nickname Valido.");	
			}
		}else {
			this.setMessages("El Nickname no debe ser vacio.");
		}
	}
	
	public boolean validateMail () {
		Usuario NewUser = new Usuario();
		Manejador man = Manejador.getInstance(); 
		UsuarioControlador controllerUser = man.getUsuarioControlador();
		if(mail != null) {
			NewUser = controllerUser.getUsuarioPorMail(mail);
			if(NewUser!= null) {
				return false;
			}else {
				return true;	
			}
			
		}else {
			return false;
		}
	}
	
	public boolean validatePassword (){
		if(password != null && password.length() >= 8) {
			if(this.repeatPassword.equals(password)) {
				return true;
			}
			else {
				return false;
			}
			
		}else{
			return false;
		}
			
	}
	
	public void registerUser() {
//		if(validateNick() && validateMail() && validatePassword()){
			Manejador man = Manejador.getInstance(); 
			UsuarioControlador controllerUser = man.getUsuarioControlador();
			controllerUser.registrarUsuario(nickname, mail, password, 0.0,new Date(),1);
			//return "home";
//		}
//		else {
//			return "register";
//		}
	}
}
