package controladores;

import java.util.Date;
import java.util.Set;

import daos.UsuarioDAO;
import logica.modelos.Contenido;
import logica.modelos.Usuario;

public class UsuarioControlador {

	public void registrarUsuario(String nickname, String mail, String password,
								Double wallet, Date expdate, int permissions) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario tempUser = new Usuario(nickname, mail, password, wallet,
										expdate, permissions);
		udao.registrarUsuario(tempUser);
	}
	//modificiar
	
	public void modificarUsuario(String nickname) {
		//UsuarioDAO udao = new UsuarioDAO();
		//Usuario tempUser = new Usuario();
		
	}
	
	public void borrarUsuario(String nickname) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario tempUser = udao.getUsuario(nickname);
		udao.borrarUsuario(tempUser);				
		System.out.println("Borrado usuario con nickname: " + nickname + " Y id: " + tempUser.getId());
	}
	
	//listar

	public Set<Contenido> getFavorites(int id){
		UsuarioDAO udao = new UsuarioDAO();
		Set<Contenido> favs = udao.getFavorites(id);
		return favs;
	}
	
	public Usuario getUsuarioPorId(int id) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario user = udao.getUsuarioPorId(id);
		return user;
	}

	public Usuario getUsuario(String nickname) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario user = udao.getUsuario(nickname);
		return user;
	}
	
	public Usuario getUsuarioPorMail(String mail) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario user = udao.getUsuarioPorMail(mail);
		return user;
	}
}