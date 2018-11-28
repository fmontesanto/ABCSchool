package negocio;

import views.ClaseView;

public class Clase {
	private String materia;
	private float horario;
	private String estado;
	private float duracion;
	private int numero;
	private Profesor profesor;
	
	public Clase(String materia, float horario, String estado, float Duracion,int numero,Profesor profesor) {
		this.materia=materia;
		this.horario=horario;
		this.estado=estado;
		this.horario=numero;
		this.numero=numero;
		this.profesor=profesor;
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
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
		return (this.numero==numero);
	}
	public ClaseView getView() {
		ClaseView clase=new ClaseView(estado, duracion, estado, duracion, numero, profesor);
		return clase;
	}

}
