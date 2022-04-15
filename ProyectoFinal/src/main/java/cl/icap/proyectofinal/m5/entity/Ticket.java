package cl.icap.proyectofinal.m5.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Ticket {
	
	@Id 
	@GeneratedValue @Column(name="idTicket")
	private String idTicket;
	private String idEstado;
	private String idUsuario;
	private String fechaCreacion;
	private String fechaTermino;
	private String tituloTicket;
	private String idUsuarioAsignado;
	
	
	public Ticket(String idTicket, String idEstado, String idUsuario, String fechaCreacion, String fechaTermino,
			String tituloTicket, String idUsuarioAsignado) {
		this.idTicket = idTicket;
		this.idEstado = idEstado;
		this.idUsuario = idUsuario;
		this.fechaCreacion = fechaCreacion;
		this.fechaTermino = fechaTermino;
		this.tituloTicket = tituloTicket;
		this.idUsuarioAsignado = idUsuarioAsignado;
	}
	
	public Ticket() {

	}

	public String getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public String getTituloTicket() {
		return tituloTicket;
	}
	public void setTituloTicket(String tituloTicket) {
		this.tituloTicket = tituloTicket;
	}
	public String getIdUsuarioAsignado() {
		return idUsuarioAsignado;
	}
	public void setIdUsuarioAsignado(String idUsuarioAsignado) {
		this.idUsuarioAsignado = idUsuarioAsignado;
	}
}
