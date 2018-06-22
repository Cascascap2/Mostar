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
//		
//		List<Categorias> categorias = cac.getAllCategorias();
//		Iterator it = categorias.iterator();
//		Categorias cat = new Categorias();
//		System.out.println("Lista de categorias: ");
//		while(it.hasNext()){
//			cat = (Categorias) it.next();
//			System.out.println(cat.getName());
//		}
		
		
		List<Categorias> categorias = cac.getAllCategorias();
		Iterator it = categorias.iterator();
		Categorias cat = new Categorias();
		System.out.println("Lista de categorias: ");
		while(it.hasNext()){
			cat = (Categorias) it.next();
			System.out.println(cat.getName());
		}
		
		
		//uc.registrarUsuario("pepe", "testing2@mail.com", "testpass", 250.50, expdate, 1);		
		//cc.altaContenido("The walking dead", "FOX", "videos/twd.mp4", "Much ad", "Serie", "/images/dead.jpg");
		//cc.altaContenido("StreamTest", "HBO", "", "A stream","Evento");
		
		//Usuario user = uc.getUsuario("testing");
		//coc.altaComentario("Pepe", "Hola, soy un comentario", "ContenidoTest");
		//coc.altaComentario("Pepe", "Hola, soy un tremendo comentario", "Lolaso22");
		//coc.altaComentario("Pepe", "Hola, soy un alto comentario", "ContenidoTest");
		
		
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
		/*
		Contenido con = cc.getContenido("ContenidoTest");
		Contenido con2 = cc.getContenido("StreamTest");
		
		int hour 	= 06;
		int minutes = 49;
		int seconds = 00;
		
		Calendar triggerTime = Calendar.getInstance();
		triggerTime.set(Calendar.HOUR, hour);
		triggerTime.set(Calendar.MINUTE, minutes);
		triggerTime.set(Calendar.SECOND, seconds);		
		
		cc.programar_stream(con2, triggerTime.getTime());
		System.out.println(con2.toString());
		
		System.out.println("Test end");
		*/
	}

}
