package daos;

import java.util.List;
import java.util.Set;

import database.UsuarioDB;
import logica.modelos.Contenido;
import logica.modelos.Usuario;

public class UsuarioDAO {

	//Toma objetos y llama a UsuarioDB para que los persista
	
	public void registrarUsuario(Usuario tempUser) {
		UsuarioDB udb = UsuarioDB.getInstance();
		udb.registrarUsuario(tempUser);		
	}
	
	//crear
	//modificar
	
	public void borrarUsuario(Usuario tempUser) {
		UsuarioDB udb = UsuarioDB.getInstance();
		udb.borrarUsuario(tempUser);
	}
	
	//listar
	
	public List<Usuario> getAllUsuario() {
		UsuarioDB cdb = UsuarioDB.getInstance();
		List<Usuario> ret= cdb.getAllUsuario();
		return ret;
	}




	
	public Usuario getUsuario(String nickname) {
		UsuarioDB udb = UsuarioDB.getInstance();
		Usuario tempUser = udb.getUsuario(nickname);
		return tempUser;
	}
	
	public Usuario getUsuarioPorMail(String mail) {
		UsuarioDB udb = UsuarioDB.getInstance();
		Usuario tempUser = udb.getUsuarioPorMail(mail);
		return tempUser;
	}
	
	public Set<Contenido> getFavorites(String nickname){
		UsuarioDB udb = UsuarioDB.getInstance();
		Set<Contenido> favs = udb.getFavorites(nickname);
		return favs;
	}
	
	public void agregarFavorito(Usuario user, Contenido con){
		UsuarioDB udb = UsuarioDB.getInstance();
		udb.agregarFavorito(user, con);
	}

	public void modificarUsuario(Usuario user) {
		UsuarioDB udb = UsuarioDB.getInstance();
		udb.modificarUsuario(user);		
	}

}
