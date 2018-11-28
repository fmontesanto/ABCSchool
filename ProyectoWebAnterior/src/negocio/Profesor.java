package negocio;

import java.util.ArrayList;
import java.util.Date;

import views.ProfesorView;

public class Profesor extends Usuario{
	private String domicilioClases;
	private float anticipacionReserva;
	private float puntuacion;
	private ArrayList<Resena> resenas;
	
	public Profesor (String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion) {
		super(dni,nombre,mail,telefono, domicilio, fechaNacimiento,password);
		this.anticipacionReserva=anticipacion;
		this.domicilioClases=domicilioClases;
	}

	public String getDomicilioClases() {
		return domicilioClases;
	}

	public void setDomicilioClases(String domicilioClases) {
		this.domicilioClases = domicilioClases;
	}

	public float getAnticipacionReserva() {
		return anticipacionReserva;
	}

	public void setAnticipacionReserva(float anticipacionReserva) {
		this.anticipacionReserva = anticipacionReserva;
	}

	public float getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void agregarResena(Resena resena) {
		resenas.add(resena);
	}
	
	public ProfesorView getView() {
		ProfesorView profView=new ProfesorView( dni,  nombre,  mail,  telefono,  domicilio,  fechaNacimiento, password,  domicilioClases, anticipacionReserva, resenas);
		return profView;	
	}
	

}
