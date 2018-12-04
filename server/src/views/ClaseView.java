package views;

import negocio.Profesor;

public class ClaseView {
	private String materia;
	private float horario;
	private String estado;
	private int idClase;
	private ProfesorView profesor;
	
	public ClaseView(String materia, float horario, String estado, Integer idClase, Profesor profesor) {
		this.materia=materia;
		this.horario=horario;
		this.estado=estado;
		this.idClase=idClase;
		this.profesor=profesor.getView();
	}
	
	public float getHorario() {
		return horario;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public int getIdClase() {
		return idClase;
	}
	
	public ProfesorView getProfesor() {
		return profesor;
	}
	
	public String getMateria() {
		return materia;
	}

}
