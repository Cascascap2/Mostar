package logica.modelos;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Permisos {
	@Id
	private int id;
	private String Name;
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
