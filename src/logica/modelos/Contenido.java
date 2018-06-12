package logica.modelos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contenidos")
public class Contenido {
	
	private String name;
	private int provider_id;
	
	
	public Contenido(String name, int providerId) {
		super();
		this.name = name;
		provider_id = providerId;
	}

	@Id
	@Column(name="nombre")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(name="provider_id")
	public int getProviderId() {
		return provider_id;
	}
	
	public void setProviderId(int providerId) {
		provider_id = providerId;
	}
	
	@Override
	public String toString() {
		return "Contenido [id=" + ", Name=" + name + ", ProviderId=" + provider_id + "]";
	}
		
}
