package controladores;

import java.util.ArrayList;
import java.util.List;

import daos.ComentarioDAO;
import logica.modelos.Comentarios;
import logica.modelos.Usuario;

public class ComentarioControlador {
	
	public void altaComentario(String user_nick, String msg, String content_name){
		//chequeos
		ComentarioDAO cdao = new ComentarioDAO();
		Comentarios com = new Comentarios(user_nick, msg, content_name);
		cdao.altaComentario(com);
	}
	
	public void borrarComentario(Comentarios com){
		ComentarioDAO cdao = new ComentarioDAO();
		cdao.borrarComentario(com);
	}
	
	public void modificarComentario(Comentarios nuevo_com){
		ComentarioDAO cdao = new ComentarioDAO();
		cdao.modificarComentario(nuevo_com);
	}
	
	public Comentarios getComentario(int id){
		ComentarioDAO cdao = new ComentarioDAO();
		Comentarios com = cdao.getComentario(id);
		return com;
	}
	
	public List<Comentarios> getAllComentariosByContName(String contenido_name){
		ComentarioDAO cdao = new ComentarioDAO();
		List<Comentarios> retlist = new ArrayList<Comentarios>();
		retlist = cdao.getAllComentariosByContName(contenido_name);
		return retlist;
	}
	
	
	
}
