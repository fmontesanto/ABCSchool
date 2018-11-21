package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "profesores")
	private Set<MateriaEntity> materias = new HashSet<MateriaEntity>();

	public ProfesorEntity() {}	
	
	public ProfesorEntity(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password, String domicilioClases, Float anticipacionReserva) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		this.domicilioClases = domicilioClases;
		this.anticipacionReserva = anticipacionReserva;
	}
	
	public List<ClaseEntity> getClases() {
		return clases;
	}

	public void setClases(List<ClaseEntity> clases) {
		this.clases = clases;
	}

	public Set<MateriaEntity> getMaterias() {
		return materias;
	}

	public void setMaterias(MateriaEntity materia) {
		materias.add(materia);
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
