package logica.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categorias {
	@Id
	private int id;
	private String name;
	private boolean father;
	private int id_Children;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFather() {
		return father;
	}
	public void setFather(boolean father) {
		this.father = father;
	}
	public int getId_Children() {
		return id_Children;
	}
	public void setId_Children(int id_Children) {
		this.id_Children = id_Children;
	}
	@Override
	public String toString() {
		return "Categorias [name=" + name + ", father=" + father + ", id_Children=" + id_Children + "]";
	}
	public Categorias(String name, boolean father, int id_Children) {
		super();
		this.name = name;
		this.father = father;
		this.id_Children = id_Children;
	}

	

}
