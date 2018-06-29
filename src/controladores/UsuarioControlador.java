package controladores;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import daos.UsuarioDAO;
import logica.modelos.Comentarios;
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
	
	public void modificarUsuario(String nickname) {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario tempUser = new Usuario();
		udao.modificarUsuario(tempUser);
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
		List<Contenido> favs = user.getFavoritesInList();
		if(favInList(favs, con.getName())){
			System.out.println("Ya en favorito");
		}
		else{
			UsuarioDAO udao = new UsuarioDAO();
			udao.agregarFavorito(user, con);
			this.modificarUsuario(user);
		}
		
	}

	public void modificarUsuario(Usuario user) {
		UsuarioDAO udao = new UsuarioDAO();
		udao.modificarUsuario(user);
	}
	
	public boolean favInList(List<Contenido> list, String cont_name){
		Iterator<Contenido> it = list.iterator();
		Contenido con = new Contenido();
		while(it.hasNext()){
			con = (Contenido) it.next();
			if(con.getName().equals(cont_name))
				return true;
		}
		return false;
	}
	
	public void mark_spoiler(Comentarios com, Usuario user){
		List<Comentarios> spoilered = user.getDados_spoiler();
		if(this.comInlist(spoilered, com.getId())){
			System.out.println("Ya le dio spoiler");
		}
		else{
			com.setSpoiler(com.getSpoiler() + 1);
			user.addSpoileredComment(com);
			this.modificarUsuario(user);
		}
	}
	
	public boolean comInlist(List<Comentarios> list, int com_id){
		Iterator<Comentarios> it = list.iterator();
		Comentarios com = new Comentarios();
		while(it.hasNext()){
			com = (Comentarios) it.next();
			if(com.getId() == com_id)
				return true;
		}
		return false;
	}
}