package logica.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Contenido {
	@Id
	private int id;
	private String Name;
	private int ProviderId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getProviderId() {
		return ProviderId;
	}
	public void setProviderId(int providerId) {
		ProviderId = providerId;
	}
	@Override
	public String toString() {
		return "Contenido [id=" + id + ", Name=" + Name + ", ProviderId=" + ProviderId + "]";
	}
	public Contenido(String name, int providerId) {
		super();
		Name = name;
		ProviderId = providerId;
	}
	
	
	
	
}
