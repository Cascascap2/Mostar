package beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig(location = "/Mostar/videos")
public class fileController {
	private Part file;
	private String filename;
	private String Description;
	private String message;
	
	
	
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

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
	    try (InputStream input = file.getInputStream()) {
	    	File nuevo = new File("Mostar/videos", filename);
	    	System.out.println("creo el archivo");
	        Files.copy(input, nuevo.toPath());
	        System.out.println("copio el archivo");
	        this.message ="Archivo cargado correctamente!!";
	        context.addMessage(null, new FacesMessage("Successful",  "Mostar dice: " + this.message) );
	    }
	    catch (IOException e) {
	    	this.message = e.getLocalizedMessage();
	    	context.addMessage(null, new FacesMessage("Warning",  "Mostar dice: " + this.message) );
	    	
	    }
	}
	
}
