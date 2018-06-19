package controladores;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import logica.modelos.Categorias;
import logica.modelos.Contenido;
import logica.modelos.Usuario;

public class test {

	public static void main(String[] args) {
		System.out.println("testing...");
		Date expdate = new Date();
		
		Manejador manejador = Manejador.getInstance();
		UsuarioControlador uc = manejador.getUsuarioControlador();
		ContenidoControlador cc = manejador.getContenidoControlador();
		CategoriaControlador cac = manejador.getCategoriaControlador();
		
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
		
		//uc.registrarUsuario("testing", "testing2@mail.com", "testpass", 250.50, expdate, 3);		
		//cc.altaContenido("ContenidoTest", "HBO", "WebContent/videos/Avangers Infinity War.mp4", "Beware spoilers", "Pelicula");
		//cc.altaContenido("StreamTest", "HBO", "", "A stream","Evento");
		
		//Usuario user = uc.getUsuario("testing");
		
		Contenido con = cc.getContenido("StreamTest");
		con.setTipo("Evento");
		cc.modificarContenido(con);
		
		Usuario user = uc.getUsuario("pepe");
		user.setWallet(200.00);
		uc.modificarUsuario(user);
		
		//uc.agregarFavorito(user, con);
		
		//uc.borrarUsuario("testing");		
		//cc.borrarContenido("ContenidoTest");
	}

}
