package dto;

import java.util.Date;

public class AlumnoDTO extends UsuarioDTO{
	private float saldoAFavor;
	
	public AlumnoDTO(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password,float saldoAFavor) {
		super( dni,  nombre,  mail,  telefono, domicilio, fechaNacimiento, password);
		this.saldoAFavor=saldoAFavor;
	}

	public float getSaldoAFavor() {
		return saldoAFavor;
	}
}
