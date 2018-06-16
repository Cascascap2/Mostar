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
	private Set<Categorias> categorias;
	
	public Contenido(){		
	}
	
	public Contenido(String name, String providerId) {
		this.name = name;
		provider_name = providerId;
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

	@Override
	public String toString() {
		return "Contenido [id=" + ", Name=" + name + ", ProviderId=" + this.provider_name + "]";
	}

		
}
