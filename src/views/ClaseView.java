package views;

import negocio.Profesor;

public class ClaseView {
	private String materia;
	private float horario;
	private String estado;
	private float duracion;
	private int numero;
	private ProfesorView profesor;
	
	public ClaseView(String materia, float horario, String estado, float Duracion,int numero,Profesor profesor) {
		this.materia=materia;
		this.horario=horario;
		this.estado=estado;
		this.horario=numero;
		this.numero=numero;
		this.profesor=profesor.getView();
	}
	
	public float getHorario() {
		return horario;
	}
	public String getEstado() {
		return estado;
	}
	public float getDuracion() {
		return duracion;
	}
	public int getNumero() {
		return numero;
	}
	public ProfesorView getProfesor() {
		return profesor;
	}
	public String getMateria() {
		return materia;
	}

}
