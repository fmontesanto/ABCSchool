package dto;

public class ResenaDTO {
	private float puntuacion;
	private String comentario;

	public ResenaDTO(float puntuacion, String comentario) {
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
