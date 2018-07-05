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
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import controladores.Manejador;
import logica.modelos.Permisos;
import logica.modelos.Usuario;

@ManagedBean(name = "sisAdminController")
@ViewScoped

public class sisAdminController implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Usuario> usu;
	private Usuario selectedUser;

	public void setSelectedUser(Usuario selectedUser) {
		this.selectedUser = selectedUser;
	}

	@ManagedProperty("#{userSisController}")
	private userSisController service;

	public List<Usuario> getUsu() {
		return usu;
	}

	public void setUsu(List<Usuario> usu) {
		this.usu = usu;
	}

	public userSisController getService() {
		return service;
	}

	public void setService(userSisController service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Usuario getSelectedUser() {
        return selectedUser;
    }

	@SuppressWarnings("static-access")
	public Boolean[] getVisible() {
		return service.getEsvisible();
	}

	@SuppressWarnings("static-access")
	public Boolean[] getEliminar() {
		return service.getEliminar();
	}

	@SuppressWarnings("static-access")
	public Permisos[] getPermiso() {
		return service.getPermiso();
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Editando Contenido", ((Usuario) event.getObject()).getNickname());
        Manejador man = Manejador.getInstance();
        man.getUsuarioControlador().modificarUsuario((Usuario) event.getObject());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Usuario) event.getObject()).getNickname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Usuario Seleccionado", ((Usuario) event.getObject()).getNickname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Usuario deseleccionado", ((Usuario) event.getObject()).getNickname());
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
		service = new userSisController();
		service.init();
		usu = service.getListUsu();
	}

}
