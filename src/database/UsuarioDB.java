package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import logica.modelos.Usuario;
//Interactua con la base de datos y objetos del dao

public class UsuarioDB {	

    private static UsuarioDB instance = null;

    public static UsuarioDB getInstance() {
        if(instance == null) {
            instance = new UsuarioDB();
        }
        return instance;
    }
	
	public void registrarUsuario(Usuario tempUser) {
		
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Usuario.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();

	try {
		session.beginTransaction();
		session.save(tempUser);
		session.getTransaction().commit();
	} finally {
		factory.close();
	}
}
	
	//modificar
	//borrar
	//listar
	//get

}
