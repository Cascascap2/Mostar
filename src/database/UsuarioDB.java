package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import logica.modelos.Usuario;
//Interactua con la base de datos y objetos del dao

public class UsuarioDB {

	private static UsuarioDB instance = null;
	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class)
			.buildSessionFactory();

	public static UsuarioDB getInstance() {
		if (instance == null) {
			instance = new UsuarioDB();
		}
		return instance;
	}

	public void registrarUsuario(Usuario tempUser) {
		Session session = this.factory.getCurrentSession();
		session.beginTransaction();
		session.save(tempUser);
		session.getTransaction().commit();
		session.close();
	}

	// modificar
	
	public void borrarUsuario(Usuario tempUser) {
		Session session = this.factory.getCurrentSession();
		session.beginTransaction();
		session.delete(tempUser);
		session.getTransaction().commit();
		session.close();
	}
	
	// listar

	public Usuario getUsuario(String nickname) {
		Session session = this.factory.getCurrentSession();
		session.beginTransaction();
		Usuario tempUser = session.byNaturalId(Usuario.class).using("nickname", nickname).load();
		session.close();
		return tempUser;
	}

}
