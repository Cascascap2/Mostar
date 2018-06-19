package logica.modelos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contenidos")
public class Contenido {
	
	private String name;
	private String provider_name;
	private String ruta;
	private int vistas;
	private double calificacion;
	private boolean visible_adm_cont;
	private boolean visible_adm_sist;
	private String descripcion;
	private Set<Categorias> categorias;
	
	public Contenido(){		
	}
		
	public Contenido(String name, String provider_name, String ruta, String descripcion) {
		this.name = name;
		this.provider_name = provider_name;
		this.ruta = ruta;
		this.vistas = 0;
		this.calificacion = 0;
		this.visible_adm_cont = false;
		this.visible_adm_sist = false;
		this.descripcion = descripcion;
	}


	@Id
	@Column(name="contenido_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="provider_id")
	public String getProviderName() {
		return this.provider_name;
	}
	
	public void setProviderName(String providerName) {
		this.provider_name = providerName;
	}

	@OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "categorias_contenido",
            joinColumns = @JoinColumn(name = "fk_contenido_name"),
            inverseJoinColumns = @JoinColumn(name = "fk_categoria"))
	public Set<Categorias> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categorias> categorias) {
		this.categorias = categorias;
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

	@Override
	public String toString() {
		return "Contenido [name=" + name + ", provider_name=" + provider_name
				+ ", ruta=" + ruta + ", vistas=" + vistas + ", calificacion="
				+ calificacion + ", visible_adm_cont=" + visible_adm_cont
				+ ", visible_adm_sist=" + visible_adm_sist + ", descripcion="
				+ descripcion + ", categorias=" + categorias + "]";
	}
	
	
		
}
