package beans;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import controladores.CategoriaControlador;
import controladores.Manejador;
import logica.modelos.Categorias;
public class categoriaController {

	private String nombre;
	private String message;
	private List<Categorias> ListaCat;
	
	@PostConstruct
	public void init(){
		Manejador man = Manejador.getInstance();
		CategoriaControlador CatCon = man.getCategoriaControlador();
		this.ListaCat = CatCon.getAllCategorias();
		System.out.println("entre al init");
		System.out.println(ListaCat.toString());
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Categorias> getListaCat() {
		return ListaCat;
	}
	public void setListaCat(List<Categorias> listaCat) {
		ListaCat = listaCat;
	}
	
	public void altaCategoria(){
		FacesContext context = FacesContext.getCurrentInstance();
		for(int i = 0; ListaCat.size()>i; i++) {
			if(ListaCat.get(i).getName().equals(nombre)){
				this.message = "No es posible crear la categoria valor duplicado";
				return;
			}
			else{
				if(ListaCat.size() == i+1){
					Manejador man = Manejador.getInstance();
					man.getCategoriaControlador().altaCategoria(nombre);
					this.message = "Categoria "+this.nombre+" Creada Correctamente";
					ListaCat = man.getCategoriaControlador().getAllCategorias();
				}
			}
		}
		context.addMessage(null, new FacesMessage("Info",this.message));
	}
	
	public void bajaCategoria(){
		FacesContext context = FacesContext.getCurrentInstance();
		for(int i = 0; ListaCat.size()>i; i++ ) {
			if(ListaCat.get(i).getName().equals(nombre)){
				Manejador man = Manejador.getInstance();
				man.getCategoriaControlador().deleteCategoria(ListaCat.get(i));
				this.message = "Categoria "+this.nombre+" eliminada Correctamente";
				ListaCat = man.getCategoriaControlador().getAllCategorias();
				this.nombre="";
				return;
			}
			else{
				if(ListaCat.size() == i+1){
					this.message = "No es posible eliminar :(, Categoria inexistente...";
				}
			}
		}
		context.addMessage(null, new FacesMessage("Error",this.message));
	}
	
	
	
}
