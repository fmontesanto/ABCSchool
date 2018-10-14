package negocio;

import views.ResenaView;

public class Resena {
	private float puntuacion;
	private String comentario;
	
	public Resena(float puntuacion, String comentario) {
		this.puntuacion=puntuacion;
		this.comentario=comentario;
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

}
