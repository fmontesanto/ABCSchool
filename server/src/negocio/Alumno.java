package negocio;

import java.util.ArrayList;
import java.util.Date;


import dao.AlumnoDAO;

import dto.AlumnoDTO;
import dto.ReservaDTO;
import views.AlumnoView;

public class Alumno extends Usuario{
	
	private Float saldoAFavor;
	private ArrayList<Reserva> reservas;
	
	public Alumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra) {
		super( dni,  nombre,  mail,  telefono, domicilio, fechaNacimiento, contra);
		this.saldoAFavor=0f;
	}
	
	public Alumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra, Float saldoAFavor) {
		super( dni,  nombre,  mail,  telefono, domicilio, fechaNacimiento, contra);
		this.saldoAFavor=saldoAFavor;
	}
	
	public Alumno(int idUsuario,String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra) {
		super(idUsuario, dni,  nombre,  mail,  telefono, domicilio, fechaNacimiento, contra);
		this.saldoAFavor=0f;
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
	public boolean sosAlumno (String alumno) {
		return this.nombre==alumno;
	}
	private ArrayList<ReservaDTO> reservas2DTO(){
		ArrayList<ReservaDTO> reservasDTO=new ArrayList<ReservaDTO>(); 
		for(Reserva reserva:reservas) {
			ReservaDTO reservaDto=reserva.toDTO();
			reservasDTO.add(reservaDto);
		}
		return reservasDTO;
	}
	public AlumnoDTO toDTO(){
		return new AlumnoDTO(idUsuario,dni, nombre, mail, telefono, domicilio, fechaNacimiento, contra, saldoAFavor);
	}


	public void update() {
		AlumnoDAO.getInstancia().modificarAlumno(this);
	}
	public void save() {
		AlumnoDAO.getInstancia().agregarAlumno(this);
	}
	public void delete() {
		AlumnoDAO.getInstancia().bajaAlumno(this);
	}
	
}

