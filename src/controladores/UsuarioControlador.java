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
	}
	
	//listar

	public Set<Contenido> getFavorites(String nickname){
		UsuarioDAO udao = new UsuarioDAO();
		Set<Contenido> favs = udao.getFavorites(nickname);
		return favs;
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
	
	public void agregarFavorito(Usuario user, Contenido con){
		UsuarioDAO udao = new UsuarioDAO();
		udao.agregarFavorito(user, con);
	}
}