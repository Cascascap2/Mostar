package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import controladores.Manejador;
import logica.modelos.Categorias;
import logica.modelos.Contenido;
	
	
@ManagedBean(name="admContentController")
@ViewScoped

public class admController implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Contenido> cont;
	private List<Categorias> cats;
         
    @ManagedProperty("#{contentController}")
    private contentController service;
     

	public List<Categorias> getCats() {
		return cats;
	}




	public void setCats(List<Categorias> cats) {
		this.cats = cats;
	}




	public List<Contenido> getCont() {
		return cont;
	}




	public void setCont(List<Contenido> cont) {
		this.cont = cont;
	}




	public contentController getService() {
		return service;
	}




	public void setService(contentController service) {
		this.service = service;
	}

	@SuppressWarnings("static-access")
	public Boolean[] getVisible(){
		return service.getEsvisible();
	}

	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Editando Contenido", ((Contenido) event.getObject()).getName());
        Manejador man = Manejador.getInstance();
        man.getContenidoControlador().modificarContenido((Contenido) event.getObject());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Contenido) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        System.out.println(event.getNewValue().toString());
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Editada", "A remplazar: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    @PostConstruct
    public void init() {
    	service = new contentController();
    	service.init();
        cont = service.getListCont();
       cats = service.getListCat();
    }

}
