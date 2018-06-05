package database;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import logica.modelos.Contenido;
import logica.modelos.Favoritos;
import logica.modelos.Usuario;
//Interactua con la base de datos y objetos del dao

public class UsuarioDB {

	private static UsuarioDB instance = null;
//	private SessionFactory SessionFactory;

	private SessionFactory SessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Usuario.class)
									.addAnnotatedClass(Favoritos.class)
									.addAnnotatedClass(Contenido.class)
									.buildSessionFactory();

/*
	public UsuarioDB() {
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    System.out.println("Hibernate Annotation Configuration loaded");
	             
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Annotation serviceRegistry created");
	             
	    this.SessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
*/	
	public static UsuarioDB getInstance() {
		if (instance == null) {
			instance = new UsuarioDB();
		}
		return instance;
	}

	public void registrarUsuario(Usuario tempUser) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(tempUser);
		session.getTransaction().commit();
		session.close();
	}

	// modificar
	
	public void borrarUsuario(Usuario tempUser) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(tempUser);
		session.getTransaction().commit();
		session.close();
	}
	
	// listar

	public Usuario getUsuario(String nickname) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		Usuario tempUser = session.byNaturalId(Usuario.class).using("nickname", nickname).load();
		session.close();
		return tempUser;
	}
	
	public Usuario getUsuarioPorMail(String mail) {
		Session session = this.SessionFactory.getCurrentSession();
		  Query q1 = session.createQuery("SELECT `mail` FROM `usuarios` WHERE `mail`=\""+ mail +"\"");
		  Usuario user = (Usuario) q1.getSingleResult();
		  return user;
	}

}
