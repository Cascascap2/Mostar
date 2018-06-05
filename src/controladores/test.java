package controladores;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		System.out.println("testing...");
		Date expdate = new Date();
		UsuarioControlador uc = new UsuarioControlador();
		uc.registrarUsuario("testing", "testing@mail.com", "testpass",
							250.50, expdate, 3);
		System.out.println("Usuario de prueba creado con exito");
		uc.borrarUsuario("testing");
		System.out.println("Usuario de prueba borrado con exito");
	}

}
