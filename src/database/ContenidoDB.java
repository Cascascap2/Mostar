package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;




import logica.modelos.Categorias;
import logica.modelos.Contenido;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//TODO listar contenido
public class ContenidoDB {
	
	private static ContenidoDB instance = null;

	private SessionFactory SessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
									.buildSessionFactory();

	public static ContenidoDB getInstance() {
		if (instance == null) {
			instance = new ContenidoDB();
		}
		return instance;
	}
	
	public void altaContenido(Contenido con){
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		
			session.save(con);
			System.out.println(con.toString());
		try{
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println("Error al persistir un contenido.");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			session.close();
		}
		
	}
	
	public void modificarContenido(Contenido con){
		System.out.println("Updating content...");
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		session.merge(con);
		session.getTransaction().commit();
		session.close();
	}
	
		public void borrarContenido(Contenido con_name) {
			Session session = this.SessionFactory.getCurrentSession();
			session.beginTransaction();
			try{				
				session.delete(con_name);
				session.getTransaction().commit();
				session.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
				session.close();
			}
			
		}
		
		// listar

		public Contenido getContenido(String con_name) {
			Session session = this.SessionFactory.getCurrentSession();
			session.beginTransaction();
			try{
				Contenido cont = session.get(Contenido.class, con_name);
				session.close(); 
				return cont;
			}catch(Exception e){
				System.out.println(e.getMessage());
				session.close();
				return null;
			}
		}
		
		public Set<Categorias> getCategorias(String con_name){
			Contenido con = this.getContenido(con_name);
			return con.getCategorias();
		}

		public List<Contenido> getAllContenido() {
			Session session = this.SessionFactory.getCurrentSession();
			session.beginTransaction();
			try{
				@SuppressWarnings("deprecation")
				Criteria criteria = session.createCriteria(Contenido.class);
				@SuppressWarnings("unchecked")
				List<Contenido> list = criteria.list();
				//session.getTransaction().commit(); Si da problemas, sacar el comentario
				session.close();
				return list;
			}catch(Exception e){
				System.out.println(e.getMessage());
				session.close();
				return new ArrayList<Contenido>();
			}	
		}

}
