package database;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import logica.modelos.Contenido;
import logica.modelos.Favorito;
import logica.modelos.Usuario;
//Interactua con la base de datos y objetos del dao

public class UsuarioDB {

	private static UsuarioDB instance = null;
//	private SessionFactory SessionFactory;

	private SessionFactory SessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
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
		Contenido con = new Contenido("Robocop", 30);
		//Contenido con2 = new Contenido("Robocop2", 30);
		Set<Contenido> favs = new HashSet<Contenido>();
		favs.add(con);
		tempUser.setFavorites(favs);
		System.out.println("Prueba de favoritos:");
		Set<Contenido> favsTest = tempUser.getFavorites();
		Iterator it = favsTest.iterator();
		while(it.hasNext()) {
			Contenido conTest = (Contenido) it.next();
			System.out.println(conTest.getName());
		}
		//tempUser.addFavorito(con2);
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

	public Usuario getUsuarioPorId(int id) {
		  Session session = this.SessionFactory.getCurrentSession();
		  session.beginTransaction();
		  Usuario user = (Usuario) session.get(Usuario.class, id);
		  session.close();
		  return user;
	}
	
	public Usuario getUsuario(String nickname) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		Usuario tempUser = session.byNaturalId(Usuario.class).using("nickname", nickname).load();
		session.close();
		return tempUser;
	}
	
	public Usuario getUsuarioPorMail(String mail) {
		  Session session = this.SessionFactory.getCurrentSession();
		  session.beginTransaction();
		  Criteria criteria = session.createCriteria(Usuario.class);
		  Usuario user = (Usuario) criteria.add(Restrictions.eq("mail", mail)).uniqueResult();
		  session.close();
		  return user;
	}
	
	public Set<Contenido> getFavorites(int id){
		Usuario user = new Usuario();
		//Usuario tempUser = getUsuarioPorId(id);
		return user.getFavorites();
	}

}
