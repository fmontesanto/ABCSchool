package dto;

import java.util.Date;


public class ProfesorDTO extends UsuarioDTO{
	
	private Float anticipacionReserva;
	private Float puntuacion;
	private String domicilioClases;
	
	public ProfesorDTO(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra, String domicilioClases,Float anticipacion) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, contra);
		this.anticipacionReserva=anticipacion;
		this.domicilioClases=domicilioClases;
	}
	
	public String getDomicilioClases() {
		return domicilioClases;
	}
	public float getAnticipacionReserva() {
		return anticipacionReserva;
	}
	public float getPuntuacion() {
		return puntuacion;
	}
	
}
