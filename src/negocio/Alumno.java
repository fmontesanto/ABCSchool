package negocio;

import java.util.ArrayList;
import java.util.Date;

import views.AlumnoView;

public class Alumno extends Usuario{
	
	private float saldoAFavor;
	private ArrayList<Reserva> reservas;
	
	public Alumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra) {
		super( dni,  nombre,  mail,  telefono, domicilio, fechaNacimiento, password);
		this.saldoAFavor=0;
	}

	public float getSaldoAFavor() {
		return saldoAFavor;
	}

	
	public void agregarSaldo(float cantidad) {
		saldoAFavor=+cantidad;
	}
	
	public void descontarSaldo (float cantidad) {
		saldoAFavor=-cantidad;
	}
	public AlumnoView getView() {
		AlumnoView alumnoView=new AlumnoView(this.getDni(),this.getNombre(),this.getMail(),this.getTelefono(),this.getDni(),this.getFechaNacimiento(),this.getPassword(), saldoAFavor);
		return alumnoView;
	}
	public boolean sosAlumno (String alumno) {
		return this.nombre==alumno;
	}

}

