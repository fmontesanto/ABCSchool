package negocio;

import views.ClaseView;

public class Clase {
	
	private String materia;
	private Float horario;
	private String estado;
	private Integer idClase;
	private Profesor profesor;
	private Reserva reserva;
	
	public Clase(Integer id, String materia, Float horario, String estado, Profesor profesor, Reserva reserva) {
		this.idClase = id;
		this.materia=materia;
		this.horario=horario;
		this.estado=estado;
		this.profesor=profesor;
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
	
	public String getMateria() {
		return materia;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public boolean sosClaseMateria(String materia) {
		return (this.materia==materia);
	}
	
	public boolean sosClaseNro(int numero) {
		return (this.idClase==numero);
	}
	public ClaseView getView() {
		ClaseView clase=new ClaseView(materia, horario, estado, idClase, profesor);
		return clase;
	}

}
