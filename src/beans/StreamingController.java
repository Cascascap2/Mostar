package beans;

import java.util.Date;

import controladores.Manejador;

public class StreamingController {
	
	private String name;
	private String ruta_trans;
	private Float precio;
	private Date fec_trans;
	private String empresa_name;
	private String descripcion;
	private String tipo = "Evento";
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRuta_trans() {
		return ruta_trans;
	}
	public void setRuta_trans(String ruta_trans) {
		this.ruta_trans = ruta_trans;
	}
	public String getEmpresa_name() {
		return empresa_name;
	}
	public void setEmpresa_name(String empresa_name) {
		this.empresa_name = empresa_name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Date getFec_trans() {
		return fec_trans;
	}
	public void setFec_trans(Date fec_trans) {
		this.fec_trans = fec_trans;
	}
	 public void addStreaming() {
		 Manejador man= Manejador.getInstance();
		 man.getContenidoControlador().altaContenido(name, empresa_name,ruta_trans, descripcion, tipo, ruta_imagen);
	 }
	
}
