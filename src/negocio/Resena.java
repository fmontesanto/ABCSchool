package negocio;

import views.ResenaView;

public class Resena {
	private Integer idResena;
	private Float puntuacion;
	private String comentario;
	private Profesor profesor;
	
	public Resena(float puntuacion, String comentario, Profesor profesor) {
		this.puntuacion=puntuacion;
		this.comentario=comentario;
		this.profesor = profesor;
	}
	
	public float getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public ResenaView getView() {
		ResenaView rv=new ResenaView(this.puntuacion,this.comentario);
		return rv;
	}
	
	public Integer getIdResena() {
		return idResena;
	}
	
	public void setIdResena(Integer idResena) {
		this.idResena = idResena;
	}
	
	public void setPuntuacion(Float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
}
