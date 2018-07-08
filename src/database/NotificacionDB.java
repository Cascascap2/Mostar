package database;

import java.util.ArrayList;
import java.util.List;

import logica.modelos.Notificacion;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class NotificacionDB {

	private static NotificacionDB instance = null;

	private SessionFactory SessionFactory = new Configuration()
									.configure("hibernate.cfg.xml")
									.buildSessionFactory();

	public static NotificacionDB getInstance() {
		if (instance == null) {
			instance = new NotificacionDB();
		}
		return instance;
	}

	public void altaNotificacion(Notificacion not) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(not);
		session.getTransaction().commit();
		session.close();
	}

	public void borrarNotificacion(Notificacion not) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			session.delete(not);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}			
	}

	public void modificarNotificacion(Notificacion nueva_not) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			session.merge(nueva_not);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
		}
		
	}

	public Notificacion getNotificacion(int id) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		try{			
			Notificacion not = session.get(Notificacion.class, id);
			session.close();
			return not;
		}catch(Exception e){
			System.out.println(e.getMessage());
			session.close();
			return null;
		}
	}

	public List<Notificacion> getAllNotificaciones(String user_name) {
		Session session = this.SessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Notificacion.class);
		criteria.add(Restrictions.eq("user_name", user_name));
		@SuppressWarnings("unchecked")
		List<Notificacion> list = criteria.list();
		session.close();
		return list;
	}

}
