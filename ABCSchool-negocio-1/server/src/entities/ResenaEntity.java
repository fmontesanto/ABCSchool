package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Resena")
public class ResenaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idResena")
	private Integer idResena;
	@Column(name="puntuacion")
	private Float puntuacion;
	@Column(name="comentario")
	private String comentario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name="idUsuario")
	protected ProfesorEntity profesor;

	
	public ResenaEntity() {}	
	
	public ResenaEntity(Float puntuacion, String comentario, ProfesorEntity profesor) {
		super();
		this.puntuacion = puntuacion;
		this.comentario = comentario;
		this.profesor = profesor;
	}

	public Integer getIdResena() {
		return idResena;
	}

	public void setIdResena(Integer idResena) {
		this.idResena = idResena;
	}

	public Float getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public ProfesorEntity getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorEntity profesor) {
		this.profesor = profesor;
	}
}
