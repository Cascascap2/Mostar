package database;

import java.util.Set;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import logica.modelos.Contenido;
import logica.modelos.Usuario;

//TODO add try and catches
public class UsuarioDB {

	private static UsuarioDB instance = null;
//	private SessionFactory SessionFactory;

	private SessionFactory SessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
									.buildSessionFactory();

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
		Usuario tempUser = session.get(Usuario.class, nickname);
		session.close(); 
		return tempUser;
	}
	
	public void agregarFavorito(Usuario user, Contenido con){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		user.addFavorito(con);
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public Usuario getUsuarioPorMail(String mail) {
		  Session session = this.SessionFactory.getCurrentSession();
		  session.beginTransaction();
		  @SuppressWarnings("deprecation")
		  Criteria criteria = session.createCriteria(Usuario.class);
		  Usuario user = (Usuario) criteria.add(Restrictions.eq("mail", mail)).uniqueResult();
		  session.close();
		  return user;
	}
	
	public Set<Contenido> getFavorites(String nickname){
		Usuario user = this.getUsuario(nickname);
		return user.getFavorites();
	}

}
