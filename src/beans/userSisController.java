package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controladores.Manejador;
import controladores.UsuarioControlador;
import logica.modelos.Permisos;
import logica.modelos.Usuario;

@ManagedBean(name = "userSisController")
@ApplicationScoped
public class userSisController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> ListUsu;
	private final static Permisos[] permiso;
	static {
		permiso = new Permisos[3];
		permiso[0]= new Permisos(1,"Cliente");
		permiso[1]= new Permisos(2,"Adm. de Contenido");
		permiso[2]= new Permisos(3,"Adm. Sistema");
		
	}
	
	private final static Boolean[] Esvisible ;
	 static {
		 Esvisible = new Boolean[2];
		 Esvisible[0] = false;
		 Esvisible[1] = true;
	 }
	 
	 
	 
	 private final static Boolean[] eliminar ;
	 static {
		 eliminar = new Boolean[2];
		 eliminar[0] = false;
		 eliminar[1] = true;
	 }
	 
	public void init(){
		Manejador man = Manejador.getInstance();
		UsuarioControlador usuCon = man.getUsuarioControlador();
		this.ListUsu = usuCon.getAllUsuario();
		System.out.println(this.ListUsu.size());
		
	}

	public static Boolean[] getEliminar() {
		return eliminar;
	}

	public List<Usuario> getListUsu() {
		return ListUsu;
	}

	public void setListUsu(List<Usuario> listUsu) {
		ListUsu = listUsu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Permisos[] getPermiso() {
		return permiso;
	}

	
	public static Boolean[] getEsvisible() {
		return Esvisible;
	}

	
}
