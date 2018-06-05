package logica.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contenidos")
public class Contenido {
	@Id
	private int id;
	@Column
	private String name;
	private int ProviderId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProviderId() {
		return ProviderId;
	}
	public void setProviderId(int providerId) {
		ProviderId = providerId;
	}
	@Override
	public String toString() {
		return "Contenido [id=" + id + ", Name=" + name + ", ProviderId=" + ProviderId + "]";
	}
	public Contenido(String name, int providerId) {
		super();
		this.name = name;
		ProviderId = providerId;
	}
	
	
	
	
}
