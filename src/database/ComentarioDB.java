package database;

import java.util.ArrayList;
import java.util.List;

import logica.modelos.Categorias;
import logica.modelos.Comentarios;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class ComentarioDB{
	
	private static ComentarioDB instance = null;

	private SessionFactory SessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
									.buildSessionFactory();

	public static ComentarioDB getInstance() {
		if (instance == null) {
			instance = new ComentarioDB();
		}
		return instance;
	}

	public void altaComentario(Comentarios com) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			session.save(com);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
	}
	
	public Comentarios getComentario(int id){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			Comentarios com = session.get(Comentarios.class, id);
			session.close();
			return com;
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
			return null;
		}
	}

	public void borrarComentario(Comentarios com) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			session.delete(com);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}		
	}

	public void modificarComentario(Comentarios nuevo_com) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			session.merge(nuevo_com);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
		
	}

	public List<Comentarios> getAllComentariosByContName(String contenido_name) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Comentarios.class);
			criteria.add(Restrictions.eq("contenido_name",contenido_name));
			@SuppressWarnings("unchecked")
			List<Comentarios> list = criteria.list();
			session.close();
			return list;
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
			return new ArrayList<Comentarios>();
		}		
	}

}
