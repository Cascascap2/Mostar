package logica.modelos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favoritos")
public class Favoritos {
	
	@Id
	int id;
	@OneToOne(mappedBy = "Contenido")
	@JoinColumn(name = "contenido_id")
	Contenido contenido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	Usuario user;

	Favoritos(){
		
	}
	
	Favoritos(Usuario usuario, Contenido contenido){
		this.user = usuario;
		this.contenido = contenido;
	}
}
