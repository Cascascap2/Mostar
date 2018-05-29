package logica.modelos;

import javax.persistence.Id;

public class Comentarios {
	@Id
	private int id;
	private int UserId;
	private String Message;
	private int Spoiler;
	private int ContenidoId;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getSpoiler() {
		return Spoiler;
	}
	public void setSpoiler(int spoiler) {
		Spoiler = spoiler;
	}
	public int getContenidoId() {
		return ContenidoId;
	}
	public void setContenidoId(int contenidoId) {
		ContenidoId = contenidoId;
	}
	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", UserId=" + UserId + ", Message=" + Message + ", Spoiler=" + Spoiler
				+ ", ContenidoId=" + ContenidoId + "]";
	}
	public Comentarios(int userId, String message, int spoiler, int contenidoId) {
		super();
		UserId = userId;
		Message = message;
		Spoiler = spoiler;
		ContenidoId = contenidoId;
	}
	
	
}
