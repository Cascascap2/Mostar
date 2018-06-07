package logica.modelos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
public class Favorito {
	
	@Column(name="Contenido_id")
	int contenido_id;
	

	public Favorito(){
		
	}
	
	Favorito(int contenido){
		this.contenido_id = contenido;
	}
	
}
