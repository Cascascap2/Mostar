package daos;

import database.UsuarioDB;
import logica.modelos.Usuario;

public class UsuarioDAO {

	//Toma objetos y llama a UsuarioDB para que los persista
	
	public void registrarUsuario(Usuario tempUser) {
		UsuarioDB udb = UsuarioDB.getInstance();
		udb.registrarUsuario(tempUser);		
	}
	
	//crear
	//modificar
	//borrar
	//listar
	//get
}
