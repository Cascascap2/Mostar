package beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import controladores.Manejador;

@MultipartConfig(location = "/Mostar/videos")
public class fileController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Part file1;
	private Part file2;
	private String filename;
	private String Description;
	private String message;
	private String tipo= "Pelicula";
	private String nick;
	
	
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	

	public Part getFile1() {
		return file1;
	}

	public void setFile1(Part file1) {
		this.file1 = file1;
	}

	public Part getFile2() {
		return file2;
	}

	public void setFile2(Part file2) {
		this.file2 = file2;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void saveVideo() {
		FacesContext context = FacesContext.getCurrentInstance();
	    try (InputStream input = file2.getInputStream()) {
	    	File nuevo = new File("C:/Users/lucas/Videos/Videos", filename+".mp4");
	    	System.out.println("creo el archivo");
	        Files.copy(input, nuevo.toPath());
	        System.out.println("copio el archivo");
	        this.message ="Video cargado correctamente!!";
	        context.addMessage(null, new FacesMessage("Info1",this.message) );
	        this.cargaFinalizada();
	    }
	    catch (IOException e) {
	    	this.message = "Error al cargar el archivo...";
	    	context.addMessage(null, new FacesMessage("Warning",  "Mostar dice: " + "Error...") );
	    	context.addMessage(null, new FacesMessage("Info1", this.message));
	    }
	}
	public void saveImagen() {
		FacesContext context = FacesContext.getCurrentInstance();
	    try (InputStream input = file1.getInputStream()) {
	    	File nuevo = new File("C:/Users/lucas/Videos/Imagenes", filename+".jpg");
	    	System.out.println("creo el archivo");
	        Files.copy(input, nuevo.toPath());
	        System.out.println("copio el archivo");
	        this.message ="Imagen cargada correctamente!!";
	        context.addMessage(null, new FacesMessage("Info2",this.message) );
	        this.cargaFinalizada();
	    }
	    catch (IOException e) {
	    	this.message = "Error al cargar el archivo...";
	    	context.addMessage(null, new FacesMessage("Warning",  "Mostar dice: " + "Error...") );
	    	context.addMessage(null, new FacesMessage("Info2", this.message));
	    }
	}
	public void saveContenido(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.saveImagen();
		this.saveVideo();
		Manejador man = Manejador.getInstance();
		man.getContenidoControlador().altaContenido(filename,nick, "http://localhost:8080/localVideo/Videos/"+this.filename+".mp4", Description, tipo, "http://localhost:8080/localVideo/Imagenes/"+this.filename+".jpg");
		context.addMessage(null, new FacesMessage("Info","El Contenido se cargo Correctamente!! ") );
		
	}
	
	public String cargaFinalizada() {
		return "admContent";
	}
	@PostConstruct
	public void init(){
		FacesContext context = FacesContext.getCurrentInstance();
		 Application application = context.getApplication();
		 userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
		 this.nick = uc.getNickname();
	}
	
}
