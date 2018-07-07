package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.push.annotation.Singleton;

import logica.modelos.Comentarios;
import logica.modelos.Contenido;
import logica.modelos.Usuario;
import controladores.ComentarioControlador;
import controladores.ContenidoControlador;
import controladores.Manejador;
import controladores.UsuarioControlador;

@Singleton
public class videoController {
	
	private String contenido_name;
	private String provider_name;
	private String ruta;
	private int vistas;
	private double calificacion;
	private String descripcion;
	private String ruta_imagen;
	private List<Comentarios> comentarios;
	private String comentario_msg;
	@ManagedProperty(value="#{userController}")
    private userController session;
	private String msg;
	private int rating;

	
	public String getContenido_name() {
		return contenido_name;
	}
	public void setContenido_name(String contenido_name) {
		this.contenido_name = contenido_name;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public int getVistas() {
		return vistas;
	}
	public void setVistas(int vistas) {
		this.vistas = vistas;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

	public String getComentario_msg() {
		return comentario_msg;
	}
	public void setComentario_msg(String comentario_msg) {
		this.comentario_msg = comentario_msg;
	}
		
	public userController getSession() {
		return session;
	}
	public void setSession(userController session) {
		this.session = session;
	}
	
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "videoController [contenido_name=" + contenido_name
				+ ", provider_name=" + provider_name + ", ruta=" + ruta
				+ ", vistas=" + vistas + ", calificacion=" + calificacion
				+ ", descripcion=" + descripcion + ", ruta_imagen="
				+ ruta_imagen + ", comentarios=" + comentarios
				+ ", comentario_msg=" + comentario_msg + "]";
	}
	
	public void getPeliculaElejida(ActionEvent event){
		this.contenido_name = (String) event.getComponent().getAttributes().get("pelicula_elejida");
		//java.lang.System.out.println("Sacando el string: " + this.contenido_name);
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		Contenido con = cc.getContenido(contenido_name);
		ComentarioControlador coc = man.getComentarioControlador();
		this.comentarios = coc.getAllComentariosByContName(contenido_name);
		this.ruta = con.getRuta();	
		cc.aumentar_view(con);
		this.vistas = con.getVistas();
		updateRating();
	}
	
	public void registrarseEnEvento(ActionEvent event){
		this.contenido_name = (String) event.getComponent().getAttributes().get("evento_elejido");
		Manejador man = Manejador.getInstance();		
		FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	    String user_nick = uc.getNickname();
		UsuarioControlador usco = man.getUsuarioControlador();
		Usuario user = usco.getUsuario(user_nick);
		if(user!=null){
			if(user.getWallet() >= 200){
				user.setWallet(user.getWallet() - 200);
				usco.modificarUsuario(user);
				uc.setWallet(user.getWallet());
				ContenidoControlador cc = man.getContenidoControlador();
				Contenido con = cc.getContenido(this.contenido_name);
				this.msg = cc.addUsuarioPermitido(con, user);
				context.addMessage(null, new FacesMessage(this.contenido_name,  this.msg) );
			}
			else{
				this.msg = "No tiene saldo suficiente para registrarse a este evento";
				context.addMessage(null, new FacesMessage("Error",  this.msg) );
			}
				
			
		}
		else{
			this.msg = "Debe estar logueado para registrarse a un evento";
			context.addMessage(null, new FacesMessage("Error",  this.msg) );
		}	    
	}
	
	public String verPelicula(){
		return "verVideo";
	}
	
	public void crearComentario(){
		Manejador man = Manejador.getInstance();
		ComentarioControlador coc = man.getComentarioControlador();
		String user_nick = this.session.getNickname();
		coc.altaComentario(user_nick, this.comentario_msg, this.contenido_name);
		this.comentarios = coc.getAllComentariosByContName(contenido_name); 
		this.comentario_msg = ""; 
	}
	
	@PostConstruct
	public void init(){
		 FacesContext context = FacesContext.getCurrentInstance();
	     Application application = context.getApplication();
	     userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	     this.session = uc;
	     this.msg = "";
	}
	
	
	//TODO controlar que solo se pueda hacer una vez
	public void likeVideo(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		UsuarioControlador uc = man.getUsuarioControlador();
		String user_nick = this.session.getNickname();
		Usuario user = uc.getUsuario(user_nick);
		Contenido con = cc.getContenido(this.contenido_name);
		FacesContext context = FacesContext.getCurrentInstance();
		if(!cc.userInList(con.getLikers(), user_nick)){
			cc.likeSinCheck(con, user);
			updateRating();
			context.addMessage(null, new FacesMessage("Exito",  "Gracias por tu calificacion"));
		}
		else
			context.addMessage(null, new FacesMessage("Error",  "Ya has dado like a este video"));
		//TODO change button color
	}
	
	public void dislikeVideo(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		UsuarioControlador uc = man.getUsuarioControlador();
		String user_nick = this.session.getNickname();
		Usuario user = uc.getUsuario(user_nick);
		Contenido con = cc.getContenido(this.contenido_name);
		FacesContext context = FacesContext.getCurrentInstance();
		if(!cc.userInList(con.getDislikers(), user_nick)){
			cc.dislikeSinCheck(con, user);
			updateRating();
			context.addMessage(null, new FacesMessage("Exito",  "Gracias por tu calificacion"));
		}
		else
			context.addMessage(null, new FacesMessage("Error",  "Ya has dado dislike a este video"));
		//TODO change button color
	}
	
	public void updateRating(){
		Manejador man = Manejador.getInstance();
		ContenidoControlador cc = man.getContenidoControlador();
		Contenido con = cc.getContenido(this.contenido_name);
		int likes = con.getLikes();
		int dislikes = con.getDislikes();
		if((likes + dislikes)==0)
			this.rating = 0;
		else
			this.rating = (likes * 100) / (likes + dislikes);
	}
	
	public void favorito(){
		Manejador man = Manejador.getInstance();
		UsuarioControlador uc = man.getUsuarioControlador();
		ContenidoControlador cc = man.getContenidoControlador();
		Contenido con = cc.getContenido(this.contenido_name);
		String user_nick = this.session.getNickname();
		Usuario user = uc.getUsuario(user_nick);
		FacesContext context = FacesContext.getCurrentInstance();
		if(!uc.favInList(user.getFavoritesInList(), this.contenido_name)){
			uc.agregarFavoritoSinCheck(user, con);
			context.addMessage(null, new FacesMessage("Exito",  "Se ah agregado esta pelicula a tu lista de favoritos"));
		}
		else
			context.addMessage(null, new FacesMessage("Error",  "Esta pelicula ya pertenece a tu lista de favoritos"));
	}
	
	public void verStream(ActionEvent event){
		this.contenido_name = (String) event.getComponent().getAttributes().get("pelicula_elejida");
		FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	    if(uc!= null && uc.isLogged() && uc.isSuscrito()){
	    	Manejador man = Manejador.getInstance();
		    ContenidoControlador cc = man.getContenidoControlador();
	    	String user_nick = uc.getNickname();
	    	Contenido con = cc.getContenido(this.contenido_name);
	    	if(!cc.userInList(con.getPermitidos(), user_nick))
	    		context.addMessage(null, new FacesMessage("Error",  "No esta registrado a este evento"));
	    }
	    context.addMessage(null, new FacesMessage("Error",  "Debe estar suscrito para registrarse y ver eventos"));
	}	
	
	public String goStream(){
		FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
	    if(uc!= null && uc.isLogged() && uc.isSuscrito()){
	    	Manejador man = Manejador.getInstance();
		    ContenidoControlador cc = man.getContenidoControlador();
	    	String user_nick = uc.getNickname();
	    	Contenido con = cc.getContenido(this.contenido_name);
	    	if(cc.userInList(con.getPermitidos(), user_nick))
	    		return "streaming";	  
	    	else
	    		return "";
	    }
	    else
	    	return "";
	}	
	
}
