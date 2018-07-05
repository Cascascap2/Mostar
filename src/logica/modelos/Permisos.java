package logica.modelos;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Permisos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String Name;
	
	
	public Permisos(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}
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
	@Override
	public String toString() {
		return "Permisos [id=" + id + ", Name=" + Name + "]";
	}
	public Permisos(String name) {
		super();
		Name = name;
	}
	
	
}
