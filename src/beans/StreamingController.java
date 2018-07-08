package beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import logica.modelos.Usuario;
import controladores.Manejador;
import controladores.UsuarioControlador;

public class StreamingController {
	private String nick;
	private String name;
	private String ruta_trans;
	private Float precio;
	private Date fec_trans;
	private String empresa_name;
	private String descripcion;
	private String tipo = "Evento";
	private String ruta_imagen = "http://localhost:8080/localVideo/Videos/";
	private Part file;
	private String message;
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRuta_trans() {
		return ruta_trans;
	}
	public void setRuta_trans(String ruta_trans) {
		this.ruta_trans = ruta_trans;
	}
	public String getEmpresa_name() {
		return empresa_name;
	}
	public void setEmpresa_name(String empresa_name) {
		this.empresa_name = empresa_name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Date getFec_trans() {
		return fec_trans;
	}
	public void setFec_trans(Date fec_trans) {
		this.fec_trans = fec_trans;
	}
	 public void addStreaming() {
		 Manejador man= Manejador.getInstance();
		 FacesContext context = FacesContext.getCurrentInstance();
		    try (InputStream input = file.getInputStream()) {
		    	File nuevo = new File("C:/Users/lucas/Videos/Imagenes", name+".jpg");
		    	System.out.println("creo el archivo");
		        Files.copy(input, nuevo.toPath());
		        System.out.println("copio el archivo");
		        this.message ="Archivo cargado correctamente!!";
		        context.addMessage(null, new FacesMessage("Successful", "Exito!") );
		        context.addMessage(null, new FacesMessage("Info",this.message) );
		        man.getContenidoControlador().altaContenido(name, empresa_name,ruta_trans, descripcion, tipo, ruta_imagen);
				 this.message = "Evento registrado con exito ...";
				 context.addMessage(null, new FacesMessage("Successful",  "Mostar dice: " + "La transaccion a sido realizada con exito...") );
				 context.addMessage(null, new FacesMessage("Info", this.message));
		    }
		    catch (IOException e) {
		    	this.message = "Error al cargar el archivo...";
		    	context.addMessage(null, new FacesMessage("Warning",  "Mostar dice: " + "Error...") );
		    	context.addMessage(null, new FacesMessage("Info", this.message));
		    }
		    
		    
		 
	 }
	 
	 @PostConstruct
	 void init() {
		 FacesContext context = FacesContext.getCurrentInstance();
		 Application application = context.getApplication();
		 userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
		 this.nick = uc.getNickname();
		 Manejador man = Manejador.getInstance();
		 UsuarioControlador usc = man.getUsuarioControlador();
		 this.empresa_name = man.getUsuarioControlador().getUsuario(nick).getNickname();
		 Usuario user = usc.getUsuario(this.nick);
		 
//			---------------------Agregar campo nombre empresa a usuarios administradores de contenido----------------------------------------
		 this.empresa_name = uc.getNombreEmpresa();
		 
	 }
	
	
}
