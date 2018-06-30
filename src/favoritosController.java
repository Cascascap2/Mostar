import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import beans.userController;


public class favoritosController {
	
	private String msg;
	

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	@PostConstruct
	public void updateFavoritos(){
		this.msg = "Contenido favorito de ";
		FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	    uc.updateFavoritos();
	}
}
