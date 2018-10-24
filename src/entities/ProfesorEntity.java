package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import entities.UsuarioEntity;


@Entity
@Table(name="Profesor")
public class ProfesorEntity extends UsuarioEntity {
	
	@Column(name="domicilioClases")
	private String domicilioClases;
	@Column(name="anticipacionReserva")
	private Float anticipacionReserva;
	@Column(name="puntuacion")
	private Float puntuacion;
	
	@OneToMany(mappedBy="profesor", cascade=CascadeType.ALL)
	private List<ResenaEntity> resenas;
	
	@OneToMany(mappedBy="profesor", cascade=CascadeType.ALL)
	private List<ClaseEntity> clases;
	
	public ProfesorEntity() {}	
	
	public ProfesorEntity(String dni, String nombre, String mail, String telefono, String domicilio,
			String fechaNacimiento, String password, String domicilioClases, Float anticipacionReserva,
			Float puntuacion) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		this.domicilioClases = domicilioClases;
		this.anticipacionReserva = anticipacionReserva;
		this.puntuacion = puntuacion;
	}

	public String getDomicilioClases() {
		return domicilioClases;
	}

	public void setDomicilioClases(String domicilioClases) {
		this.domicilioClases = domicilioClases;
	}

	public Float getAnticipacionReserva() {
		return anticipacionReserva;
	}

	public void setAnticipacionReserva(Float anticipacionReserva) {
		this.anticipacionReserva = anticipacionReserva;
	}

	public Float getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public List<ResenaEntity> getResenas() {
		return resenas;
	}

	public void setResenas(List<ResenaEntity> resenas) {
		this.resenas = resenas;
	}	
}
