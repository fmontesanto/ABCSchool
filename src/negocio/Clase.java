package negocio;

import dao.ClaseDAO;
import dao.MateriaDAO;
import views.ClaseView;

import java.sql.Date;

public class Clase {
	
	private Materia materia;
	private Float horario;
	private Float horaInicio;
	private Float horaFin;
	private String estado; //libre, pendiente, ocupada
	private Integer idClase;
	private Profesor profesor;
	
	public Clase(Integer id,Float horario, String estado, Profesor profesor) {
		this.idClase=id;
		this.horario=horario;
		this.estado=estado;
		this.profesor=profesor;
	}
	
	public Clase(Materia materia, Float horario, String estado, Integer idClase, Profesor profesor, Reserva reserva) {
		this.materia=materia;
		this.materia = materia;
		this.horario = horario;
		this.estado = estado;
		this.idClase = idClase;
		this.profesor = profesor;
}

	public Clase(Materia mat, Date fecha, float horaInicio, float horaFin, String estado, int numero, Profesor dniProfesor) {
		this.materia = mat;
		this.horaInicio=horaInicio;
		this.horaFin=horaFin;
		this.horario = horario;
		this.estado = estado;
		this.idClase = idClase;
		this.profesor = profesor;
	}

	public float getHorario() {
		return horario;
	}
	public void setHorario(float horario) {
		this.horario = horario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getNumero() {
		return idClase;
	}
	
	public void setNumero(int numero) {
		this.idClase = numero;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	
	public Float getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Float horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Float getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Float horaFin) {
		this.horaFin = horaFin;
	}

	public void agregarProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public Materia getMateria() {
		return materia;
	}
	
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public boolean sosClaseMateria(Materia materia) {
		return (this.materia==materia);
	}
	
	public boolean sosClaseNro(int numero) {
		return (this.idClase==numero);
	}

	public void save() {
		ClaseDAO.getInstancia().agregarClase(this);
	}
	
	/*public ClaseView getView() {
		ClaseView clase=new ClaseView(materia, horario, estado, idClase, profesor);
		return clase;
	}*/

}
