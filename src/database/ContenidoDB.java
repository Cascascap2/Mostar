package database;

import java.util.Set;

import logica.modelos.Categorias;
import logica.modelos.Contenido;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//TODO add try and catches
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
		session.getTransaction().commit();
		session.close();
	}
	
	// modificar
	
		public void borrarContenido(Contenido con_name) {
			Session session = this.SessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(con_name);
			session.getTransaction().commit();
			session.close();
		}
		
		// listar

		public Contenido getContenido(String con_name) {
			Session session = this.SessionFactory.getCurrentSession();
			session.beginTransaction();
			Contenido cont = session.get(Contenido.class, con_name);
			session.close(); 
			return cont;
		}
		
		public Set<Categorias> getCategorias(String con_name){
			Contenido con = this.getContenido(con_name);
			return con.getCategorias();
		}

}
