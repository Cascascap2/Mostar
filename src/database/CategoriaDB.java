package database;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteCategoria(Categorias c){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		session.close();
	}
	

	public Set<Categorias> getAllCategorias(){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		//Set<Categorias> categorias = new HashSet<Categorias>();
		try{
			Criteria criteria = session.createCriteria(Categorias.class);
			Set<Categorias> list = (Set<Categorias>) criteria.list();
			session.getTransaction().commit();
			session.close();
			return list;
		}catch(Exception e){
			return new HashSet<Categorias>();
		}		
	}
}
