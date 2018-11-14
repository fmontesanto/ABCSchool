package negocio;

import dao.ClaseDAO;
import views.ClaseView;

public class Clase {
	
	private Materia materia;
	private Float horario;
	private String estado; //libre, pendiente, ocupada
	private Integer idClase;
	private Profesor profesor;
	private Reserva reserva;
	
	public Clase( Integer id,Float horario, String estado, Profesor profesor) {
		this.idClase=id;
		this.horario=horario;
		this.estado=estado;
		this.profesor=profesor;
	}
	
	public Clase(Materia materia, Float horario, String estado, Integer idClase, Profesor profesor, Reserva reserva) {
		super();
		this.materia = materia;
		this.horario = horario;
		this.estado = estado;
		this.idClase = idClase;
		this.profesor = profesor;
		this.reserva = reserva;
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
	
	/*public ClaseView getView() {
		ClaseView clase=new ClaseView(materia, horario, estado, idClase, profesor);
		return clase;
	}*/

}
