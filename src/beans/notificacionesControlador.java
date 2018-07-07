package beans;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.push.annotation.Singleton;

@Singleton
public class notificacionesControlador {
	private String msg;
	private static notificacionesControlador instance = null;
	
	public notificacionesControlador() {
		
	}
	
	public static notificacionesControlador getInstance() {
      if(instance == null) {
         instance = new notificacionesControlador();
      }
      return instance;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@PostConstruct
	public void init(){
		this.msg = "";
	}
		
	public void mostrarNotificacion(){
		System.out.println("msgj: " + this.msg);
		if(!this.msg.equals("")){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Evento",  this.msg));
			this.msg="";
		}
	}
	
	public void readyNotification(String msg){
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("test here");
	    Application application = context.getApplication();
	    System.out.println("test there");
	    userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	    System.out.println("testing testerman: " + uc.getNickname());
	    uc.setNotif_msg(msg);
	}
	
}
