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
	//borrar
	//listar
	//get
}