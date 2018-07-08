package beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import logica.modelos.Usuario;
import controladores.Manejador;
import controladores.UsuarioControlador;

public class suscripcionController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dia;
	private int mes;
	private int year;
	private String expDateString;
	
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getExpDateString() {
		return expDateString;
	}

	public void setExpDateString(String expDateString) {
		this.expDateString = expDateString;
	}

	@PostConstruct
	public void init(){
		FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	    String nick = uc.getNickname();
	    Manejador man = Manejador.getInstance();
	    UsuarioControlador ucc = man.getUsuarioControlador();
	    Usuario user = ucc.getUsuario(nick);
	    Calendar cal = Calendar.getInstance();
		Date date = user.getDateExpiration();
		cal.setTime(date);
		if(date!=null){
			java.lang.System.out.println("Construyendo date: ");
			this.dia = cal.get(Calendar.DAY_OF_MONTH);
			this.mes = cal.get(Calendar.MONTH) + 1 ; //+1 porque los meses empiezan en 0
			this.year = cal.get(Calendar.YEAR);
			this.expDateString = String.valueOf(this.dia) + "/" + String.valueOf(this.mes) + "/" + String.valueOf(this.year);
		}		
	}
	
}
