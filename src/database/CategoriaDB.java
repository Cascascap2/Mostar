package database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import logica.modelos.Categorias;
public class CategoriaDB {
	
	private static CategoriaDB instance = null;

	private SessionFactory SessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
									.buildSessionFactory();

	public static CategoriaDB getInstance() {
		if (instance == null) {
			instance = new CategoriaDB();
		}
		return instance;
	}

	public void altaCategoria(Categorias c){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
			session.save(c);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
	}
	
	public void modificarCategoria(Categorias cat){
		System.out.println("Updating category...");
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		session.merge(cat);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteCategoria(Categorias c){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
			session.delete(c);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
		
	}
	
	public List<Categorias> getAllCategorias(){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Categorias.class);
			@SuppressWarnings("unchecked")
			List<Categorias> list = criteria.list();
			//session.getTransaction().commit(); Si da problemas, sacar el comentario
			session.close();
			return list;
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
			return new ArrayList<Categorias>();
		}		
	}
}
