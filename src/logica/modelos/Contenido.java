package logica.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "contenidos")
public class Contenido {
	
	private String name;
	private String provider_name;
	private String ruta;
	private int vistas;
	private boolean visible_adm_cont;
	private boolean visible_adm_sist;
	private String descripcion;
	private String tipo;
	private Date hora_de_alta;
	private Date hora_streaming;
	private Set<Categorias> categorias;
	private String ruta_imagen;
	private int likes;
	private int dislikes;
	private List<Usuario> likers;
	private List<Usuario> dislikers;
	
	public Contenido(){		
	}
		
	public Contenido(String name, String provider_name, String ruta, String descripcion, String tipo, String ruta_imagen) {
		this.name = name;
		this.provider_name = provider_name;
		this.ruta = ruta;
		this.vistas = 0;
		this.likes = 0;
		this.dislikes = 0;
		this.visible_adm_cont = false;
		this.visible_adm_sist = false;
		this.descripcion = descripcion;
		this.tipo = tipo;
		Calendar cal = Calendar.getInstance();		
		this.hora_de_alta = new Date();
		this.hora_de_alta = cal.getTime();
		this.hora_streaming = null;
		this.ruta_imagen = ruta_imagen;
	}


	@Id
	@Column(name="contenido_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "categorias_contenido",
            joinColumns = @JoinColumn(name = "fk_contenido_name"),
            inverseJoinColumns = @JoinColumn(name = "fk_categoria"))
	public Set<Categorias> getCategorias() {
		return categorias;
	}
		
	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "likes_contenido",
            joinColumns = @JoinColumn(name = "fk_user_name"),
            inverseJoinColumns = @JoinColumn(name = "fk_contenido_name"))
	public List<Usuario> getLikers() {
		return likers;
	}

	public void setLikers(List<Usuario> likers) {
		this.likers = likers;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "dislikes_contenido",
            joinColumns = @JoinColumn(name = "fk_user_name"),
            inverseJoinColumns = @JoinColumn(name = "fk_contenido_name"))
	public List<Usuario> getDislikers() {
		return dislikers;
	}

	public void setDislikers(List<Usuario> dislikers) {
		this.dislikers = dislikers;
	}

	@Transient
	public List<Categorias> getCategoriasAsList(){
		List<Categorias> ret = new ArrayList<Categorias>();
		Iterator it = this.getCategorias().iterator();
		Categorias cat = new Categorias();
		while(it.hasNext()){
			cat = (Categorias) it.next();
			ret.add(cat);
		}
		return ret;
	}

	public void setCategorias(Set<Categorias> categorias) {
		this.categorias = categorias;
	}
	
	@Column(name="provider_name")
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
	
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public boolean isVisible_adm_cont() {
		return visible_adm_cont;
	}

	public void setVisible_adm_cont(boolean visible_adm_cont) {
		this.visible_adm_cont = visible_adm_cont;
	}
	

	public boolean isVisible_adm_sist() {
		return visible_adm_sist;
	}

	public void setVisible_adm_sist(boolean visible_adm_sist) {
		this.visible_adm_sist = visible_adm_sist;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	public Date getHora_de_alta() {
		return hora_de_alta;
	}

	public void setHora_de_alta(Date hora_de_alta) {
		this.hora_de_alta = hora_de_alta;
	}

	public Date getHora_streaming() {
		return hora_streaming;
	}

	public void setHora_streaming(Date hora_streaming) {
		this.hora_streaming = hora_streaming;
	}

	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}
	
	public void add_categoria(Categorias cat){
		this.categorias.add(cat);
	}
	
	public void add_liker(Usuario user){
		this.likers.add(user);
	}
	
	public void add_disiker(Usuario user) {
		this.dislikers.add(user);
	}

	@Override
	public String toString() {
		return "Contenido [name=" + name + ", provider_name=" + provider_name
				+ ", ruta=" + ruta + ", vistas=" + vistas
				+ ", visible_adm_cont=" + visible_adm_cont
				+ ", visible_adm_sist=" + visible_adm_sist + ", descripcion="
				+ descripcion + ", tipo=" + tipo + ", hora_de_alta="
				+ hora_de_alta + ", hora_streaming=" + hora_streaming
				+ ", categorias=" + categorias + ", ruta_imagen=" + ruta_imagen
				+ ", likes=" + likes + ", dislikes=" + dislikes + "]";
	}

	

		
}
