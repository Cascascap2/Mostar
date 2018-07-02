package controladores;

import java.util.Calendar;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import logica.modelos.Categorias;
import logica.modelos.Comentarios;
import logica.modelos.Contenido;
import logica.modelos.Usuario;

public class test {

	public static void main(String[] args) {
		System.out.println("testing...");
		
		Manejador manejador = Manejador.getInstance();
		UsuarioControlador uc = manejador.getUsuarioControlador();
		ContenidoControlador cc = manejador.getContenidoControlador();
		ComentarioControlador coc = manejador.getComentarioControlador();
		CategoriaControlador cac = manejador.getCategoriaControlador();		
		
		/*
				//SPOILER
		Usuario user = uc.getUsuario("pepe");
		Comentarios com = coc.getComentario(7);
		uc.mark_spoiler(com, user);
		*/
		
		/*
				//USUARIOS PERMITIDOS A EVENTOS
		Usuario user = uc.getUsuario("pepe");
		Contenido con = cc.getContenido("Toc toc");
		cc.addUsuarioPermitido(con, user);
		*/
		
				//GET CATEGORIAS
		/*
		List<Categorias> categorias = cac.getAllCategorias();
		Iterator it = categorias.iterator();
		Categorias cat = new Categorias();
		System.out.println("Lista de categorias: ");
		while(it.hasNext()){
			cat = (Categorias) it.next();
			System.out.println(cat.getName());
		}
		*/
		
				//COMENTARIOS
		//uc.registrarUsuario("pepe", "testing2@mail.com", "testpass", 250.50, expdate, 1);		
		//cc.altaContenido("The walking dead2", "FOX", "videos/twd.mp4", "Much ad", "Serie", "/images/dead.jpg");
		
		//Usuario user = uc.getUsuario("testing");
		//coc.altaComentario("Pepe", "Hola, soy un comentario", "ContenidoTest");
		//coc.altaComentario("Pepe", "Hola, soy un tremendo comentario", "Lolaso22");
		//coc.altaComentario("Pepe", "Hola, soy un alto comentario", "ContenidoTest");
		
				//BUSQUEDA POR CATEGORIA
		/*
		Contenido con = cc.getContenido("Toc toc");
		//Categorias cat = cac.getCategoria("Comedia");		
		//con.add_categoria(cat);
		//cc.modificarContenido(con);
		List<Contenido> con_por_cat = cc.buscar_por_categoria("Comedia");
		Iterator it = con_por_cat.iterator();
		while(it.hasNext()){
			con = (Contenido) it.next();
			System.out.println(con.getName());
		}
		*/
		
				//BUSQUEDA POR CARACTERES
		/*
		List<Contenido> con_por_caracter = cc.buscar_por_chars_al_comienzo("Toc");
		Iterator it = con_por_caracter.iterator();
		Contenido con = new Contenido();
		while(it.hasNext()){
			con = (Contenido) it.next();
			System.out.println(con.getName());
		}
		*/
		
		/*
				//LIKES
		Usuario user = uc.getUsuario("pepe");
		Contenido con = cc.getContenido("Deadpool 2");
		//cc.like(con, user);
		List<Usuario> users = con.getLikers();
		Iterator it = users.iterator();
		while(it.hasNext()){
			Usuario user2 = (Usuario) it.next();
			System.out.println(user2.getNickname());
		}
		*/
		
		/*
				//DISLIKES
		Usuario user = uc.getUsuario("pepe");
		Contenido con = cc.getContenido("Deadpool 2");
		cc.dislike(con, user);
		*/
		
		/*
				//FAVORITOS
		Usuario user = uc.getUsuario("pepe");
		Contenido con = cc.getContenido("Deadpool 2");
		uc.agregarFavorito(user, con);
		*/
		
				//SPOILERS
		//Usuario user = uc.getUsuario("pepe");
		//Comentarios com = coc.getComentario(7);
		//coc.mark_spoiler(com, user);
		
		/*
		Contenido con = cc.getContenido("StreamTest");
		con.setTipo("Evento");
		cc.modificarContenido(con);
		Usuario user = uc.getUsuario("pepe");
		user.setWallet(200.00);
		uc.modificarUsuario(user);
		*/
		
		//uc.agregarFavorito(user, con);
		
		//uc.borrarUsuario("testing");		
		//cc.borrarContenido("ContenidoTest");
		
				//Programar Stream
		/*
		Contenido con2 = cc.getContenido("StreamTest");
		System.out.println("Test get");
		
		int hour 	= 01;
		int minutes = 40;
		int seconds = 00;
		
		Calendar triggerTime = Calendar.getInstance();
		triggerTime.set(Calendar.HOUR, hour);
		triggerTime.set(Calendar.MINUTE, minutes);
		triggerTime.set(Calendar.SECOND, seconds);		
		
		cc.programar_stream(con2, triggerTime.getTime());
		System.out.println(triggerTime.getTime().toString());
		System.out.println("Test end");
		*/
		
	}

}
