package controladores;

import daos.UsuarioDAO;
import logica.modelos.Usuario;

public class UsuarioControlador {

	public void registrarUsuario(String nickname, String mail, String password) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario tempUser = new Usuario(nickname, mail, password);
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


	public Usuario getUsuario(String nickname) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario user = udao.getUsuario(nickname);
		return user;
	}
}