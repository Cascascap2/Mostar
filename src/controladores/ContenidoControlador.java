package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import logica.eventos.StreamAlert;
import logica.modelos.Categorias;
import logica.modelos.Contenido;
import logica.modelos.Usuario;
import daos.ContenidoDAO;

public class ContenidoControlador {

	public void altaContenido(String name, String empresa_name, String ruta, String descripcion, String tipo, String ruta_imagen){
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido contenido = new Contenido(name, empresa_name, ruta, descripcion, tipo, ruta_imagen);
		cdao.altaContenido(contenido);
	}

	public void borrarContenido(String name) {
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido tempUser = cdao.getContenido(name);
		cdao.borrarContenido(tempUser);				
	}

	public Set<Categorias> getCategorias(String name){
		ContenidoDAO cdao = new ContenidoDAO();
		Set<Categorias> categorias = cdao.getCategorias(name);
		return categorias;
	}

	public Contenido getContenido(String name) {
		ContenidoDAO cdao = new ContenidoDAO();
		Contenido content = cdao.getContenido(name);
		return content;
	}
	
	public List<Contenido> getAllContenido(){
		ContenidoDAO cdao = new ContenidoDAO();
		List<Contenido> ret = cdao.getAllContenido();
		return ret;
	}
	
	public void modificarContenido(Contenido con){
		ContenidoDAO cdao = new ContenidoDAO();
		cdao.modificarContenido(con);
	}
	
	public void programar_stream(Contenido con){
		//ContenidoDAO cdao = new ContenidoDAO();		
		//cdao.modificarContenido(con);
		
		Date hora_de_comienzo = con.getHora_streaming();
		JobDetail evento = JobBuilder.newJob(StreamAlert.class).withIdentity(con.getName()).build();
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
							.startAt(hora_de_comienzo).forJob(con.getName()).build();
		
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			scheduler.scheduleJob(evento, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void aumentar_view(Contenido con){
		con.setVistas(con.getVistas()+1);
		this.modificarContenido(con);
	}
	
	public boolean tiene_categoria(Contenido con, String cat_check){
		List<Categorias> cats = new ArrayList<Categorias>();
		cats = con.getCategoriasAsList();
		Iterator<Categorias> it = cats.iterator();
		Categorias cat = new Categorias();
		while(it.hasNext()){
			cat = (Categorias) it.next();
			if(cat.getName().equals(cat_check))
				return true;
		}
		return false;
	}
	
	
	public List<Contenido> buscar_por_categoria(String cat_name){
		List<Contenido> allContent = this.getAllContenido();
		Iterator<Contenido> it = allContent.iterator();
		List<Contenido> ret = new ArrayList<Contenido>();
		Contenido con = new Contenido();
		while(it.hasNext()){
			con = (Contenido) it.next();
			if(this.tiene_categoria(con, cat_name)){
				ret.add(con);
			}
		}
		return ret;
	}
	
	public List<Contenido> buscar_por_chars_al_comienzo(String con_chars){
		String lowercase_chars = con_chars.toLowerCase();
		List<Contenido> allContent = this.getAllContenido();
		Iterator<Contenido> it = allContent.iterator();
		List<Contenido> ret = new ArrayList<Contenido>();
		Contenido con = new Contenido();
		while(it.hasNext()){
			con = (Contenido) it.next();
			if(con.getName().toLowerCase().contains(lowercase_chars))
				ret.add(con);
		}
		return ret;
	}
	
	//TODO get 5 from buscar_por_chars si es necesario
	
	public boolean user_gave_like(){
		
		return false;
	}
	
	public boolean user_gave_dislike(){
		
		return false;
	}
	
	public void like(Contenido con, Usuario user){
		List<Usuario> likers = con.getLikers();
		if(userInList(likers, user.getNickname())){
			System.out.println("Ya dio like");
		}
		else{
			con.setLikes(con.getLikes() + 1);
			con.add_liker(user);
			this.modificarContenido(con);
		}
	}
	
	public void likeSinCheck(Contenido con, Usuario user){
		con.setLikes(con.getLikes() + 1);
		con.add_liker(user);
		this.modificarContenido(con);
		
	}
	
	public void dislike(Contenido con, Usuario user){
		List<Usuario> dislikers = con.getDislikers();
		if(userInList(dislikers, user.getNickname())){
			System.out.println("Ya dio dislike");
		}
		else{
			con.setDislikes(con.getDislikes() + 1);
			con.add_disiker(user);
			this.modificarContenido(con);
		}
	}
	
	public void dislikeSinCheck(Contenido con, Usuario user){
		con.setDislikes(con.getDislikes() + 1);
		con.add_disiker(user);
		this.modificarContenido(con);
		
	}
	
	public boolean userInList(List<Usuario> list, String user_nick){
		Iterator<Usuario> it = list.iterator();
		Usuario usr = new Usuario();
		while(it.hasNext()){
			usr = (Usuario) it.next();
			if(usr.getNickname().equals(user_nick))
				return true;
		}
		return false;
	}
	
	public String addUsuarioPermitido(Contenido con, Usuario user){
		List<Usuario> permitidos = con.getPermitidos();
		if(userInList(permitidos, user.getNickname())){
			return "Ya tiene permisos para este evento";
		}
		else{
			con.add_usuario_permitido(user);
			this.modificarContenido(con);
			return "Se ah registrado correctamente a este evento";
		}
	}
	
	public boolean usuarioPermitido(String user, Contenido con){
		if(userInList(con.getPermitidos(), user))
				return true;
		return false;
	}

}
