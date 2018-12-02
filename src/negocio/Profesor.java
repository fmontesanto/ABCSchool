package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;


import dao.ProfesorDAO;

import dto.ProfesorDTO;

import views.ProfesorView;

public class Profesor extends Usuario{
	private String domicilioClases;
	private Float anticipacionReserva;
	private Float puntuacion;
	private ArrayList<Resena> resenas;
	private HashSet<Materia>materias;
	
	public Profesor (String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra, String domicilioClases,float anticipacion) {
		super(dni,nombre,mail,telefono, domicilio, fechaNacimiento,contra);
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
		ProfesorView profView=new ProfesorView(dni,  nombre,  mail,  telefono,  domicilio,  fechaNacimiento, contra,  domicilioClases, anticipacionReserva, resenas);
		return profView;	
	}

	public HashSet<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(HashSet<Materia> materias) {
		this.materias = materias;
	}

    public void save() {
		ProfesorDAO.getInstancia().agregarProfesor(this);
    }

	public void update() {
		ProfesorDAO.getInstancia().modificarProfesor(this);
	}

	public void delete() {
		ProfesorDAO.getInstancia().bajaProfesor(this);
	}
	public void calcularPuntuacion() {
		float sumaPuntuacion=0;
		for (int i=0;i<resenas.size();i++) {
			puntuacion=+resenas.get(i).getPuntuacion();
		}
		this.puntuacion=(sumaPuntuacion/resenas.size());
	}
	public ProfesorDTO toDTO(){
		return new ProfesorDTO(dni, nombre, mail, telefono, domicilio, fechaNacimiento, contra, domicilioClases, anticipacionReserva);

	}
}
