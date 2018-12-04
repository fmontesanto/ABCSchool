package views;

import java.util.Date;

public class AlumnoView extends UsuarioView{
	private float saldoAFavor;
	
	public AlumnoView(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password,float saldoAFavor) {
		super( dni,  nombre,  mail,  telefono, domicilio, fechaNacimiento, password);
		this.saldoAFavor=saldoAFavor;
	}

	public float getSaldoAFavor() {
		return saldoAFavor;
	}
}
