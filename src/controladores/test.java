package controladores;

public class test {

	public static void main(String[] args) {
		System.out.println("testing...");
		UsuarioControlador uc = new UsuarioControlador();
		uc.registrarUsuario("testing2", "testing2@mail.com", "testpass");
		System.out.println("Usuario de prueba creado con exito");
		uc.borrarUsuario("testing");
	}

}
