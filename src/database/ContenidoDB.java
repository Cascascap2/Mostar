package database;

import java.util.Set;

import logica.modelos.Categorias;
import logica.modelos.Contenido;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//TODO modificar, listar contenido
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
		try{
			session.save(con);
			System.out.println(con.toString());
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println("Error al persistir un contenido.");
			System.out.println(e.getMessage());
			session.close();
		}
		
	}
	
	// modificar
	
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

}
