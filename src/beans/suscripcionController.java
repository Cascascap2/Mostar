package beans;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public class suscripcionController {

	private String ExpDateString;

	public String getExpDateString() {
		return ExpDateString;
	}

	public void setExpDateString(String expDateString) {
		ExpDateString = expDateString;
	}
	
	@PostConstruct
	public void init(){
		FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	    
		LocalDateTime ldt = LocalDateTime.ofInstant(uc.getDateExpiration().toInstant(), ZoneId.systemDefault());
		System.out.println("test");
		Locale spanish = new Locale("es", "ES");
		System.out.println("test");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy", spanish);
		System.out.println("test");
		this.ExpDateString = ldt.format(format);
		System.out.println("date: " + this.ExpDateString);
	}
	
}
