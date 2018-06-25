package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controladores.CategoriaControlador;
import controladores.ContenidoControlador;
import controladores.Manejador;
import logica.modelos.Categorias;
import logica.modelos.Contenido;

 
@ManagedBean(name = "carService")
@ApplicationScoped
public class contentController implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Contenido> ListCont;
	private List<Categorias> ListCat;
	private final static Boolean[] EsVisible;
	static {
        EsVisible = new Boolean[2];
        EsVisible[0] = false;
        EsVisible[1] = true;
	}
	
	public void init(){
		Manejador man = Manejador.getInstance();
		CategoriaControlador CatCon = man.getCategoriaControlador();
		this.ListCat = CatCon.getAllCategorias();
		ContenidoControlador ContCon = man.getContenidoControlador();
		this.ListCont = ContCon.getAllContenido();
		System.out.println(this.ListCont.size());
	}
	public List<Contenido> getListCont() {
		return ListCont;
	}
	public void setListCont(List<Contenido> listCont) {
		ListCont = listCont;
	}
	public List<Categorias> getListCat() {
		return ListCat;
	}
	public void setListCat(List<Categorias> listCat) {
		ListCat = listCat;
	}
	public static Boolean[] getEsvisible() {
		return EsVisible;
	}
	
	
	
}

