package daos;

import java.util.ArrayList;
import java.util.List;

import database.ComentarioDB;
import logica.modelos.Comentarios;
import logica.modelos.Notificacion;

public class ComentarioDAO {

	public void altaComentario(Comentarios com) {
		ComentarioDB cdb = ComentarioDB.getInstance();
		cdb.altaComentario(com);
	}

	public Comentarios getComentario(int id) {
		ComentarioDB cdb = ComentarioDB.getInstance();
		Comentarios com = cdb.getComentario(id);
		return com;
	}

	public void borrarComentario(Comentarios com) {
		ComentarioDB cdb = ComentarioDB.getInstance();
		cdb.borrarComentario(com);		
	}

	public void modificarComentario(Comentarios nuevo_com) {
		ComentarioDB cdb = ComentarioDB.getInstance();
		cdb.modificarComentario(nuevo_com);
		
	}

	public List<Comentarios> getAllComentariosByContName(String contenido_name) {
		ComentarioDB cdb = ComentarioDB.getInstance();
		List<Comentarios> retlist = new ArrayList<Comentarios>();
		retlist = cdb.getAllComentariosByContName(contenido_name);
		return retlist;
	}



}
