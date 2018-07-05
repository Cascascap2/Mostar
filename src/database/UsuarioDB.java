package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import logica.modelos.Contenido;
import logica.modelos.Usuario;

//TODO add modificar y listar usuarios
public class UsuarioDB {

	private static UsuarioDB instance = null;

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
		try{			
			session.save(tempUser);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
		
	}
	
	public List<Usuario> getAllUsuario() {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Usuario.class);
			@SuppressWarnings("unchecked")
			List<Usuario> list = criteria.list();
			//session.getTransaction().commit(); Si da problemas, sacar el comentario
			session.close();
			return list;
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
			return new ArrayList<Usuario>();
		}	
	}


	public void modificarUsuario(Usuario user){
		System.out.println("Updating user...");
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public void borrarUsuario(Usuario tempUser) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			session.delete(tempUser);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
		
	}
	
	// listar

	public Usuario getUsuario(String nickname) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			Usuario tempUser = session.get(Usuario.class, nickname);
			session.close(); 
			return tempUser;
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
			return null;
		}		
	}
	
	public void agregarFavorito(Usuario user, Contenido con){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			user.addFavorito(con);
			session.update(user);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
		
	}
	
	public Usuario getUsuarioPorMail(String mail) {
		  Session session = this.SessionFactory.getCurrentSession();
		  session.beginTransaction();
		  try{
			  @SuppressWarnings("deprecation")
			  Criteria criteria = session.createCriteria(Usuario.class);
			  Usuario user = (Usuario) criteria.add(Restrictions.eq("mail", mail)).uniqueResult();
			  session.close();
			  return user; 
		  }catch(Exception e){
			  session.close();
			  return null;
		  }
		  
	}
	
	public Set<Contenido> getFavorites(String nickname){
		Usuario user = this.getUsuario(nickname);
		return user.getFavorites();
	}

}
