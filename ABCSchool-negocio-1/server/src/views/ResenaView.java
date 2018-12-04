package views;

public class ResenaView {
	private float puntuacion;
	private String comentario;

	public ResenaView(float puntuacion, String comentario) {
		this.puntuacion=puntuacion;
		this.comentario=comentario;
	}
	public float getPuntuacion() {
		return puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

}
