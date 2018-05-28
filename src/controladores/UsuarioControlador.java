package controladores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import logica.modelos.Usuario;

public class UsuarioControlador {

	public void crearUsuarioDePrueba() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creando objecto de prueba..");
			Usuario tempUser = new Usuario("Eltestero", "testero@mail.com", "no");

			session.beginTransaction();
			session.save(tempUser);
			session.getTransaction().commit();
			System.out.println("Usuario creado con exito");
		} finally {
			factory.close();
		}
	}

}
