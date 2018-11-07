package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Materia")
public class MateriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idMateria")
	private Integer idMateria;
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn (name="idClase")
	protected ClaseEntity clase;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "MateriaProfesor", 
        joinColumns = { @JoinColumn(name = "idMateria") }, 
        inverseJoinColumns = { @JoinColumn(name = "idUsuario") } )
    Set<ProfesorEntity> profesores = new HashSet<ProfesorEntity>();

	public MateriaEntity(){}
	
	public MateriaEntity(String nombre, ClaseEntity clase) {
		super();
		this.nombre = nombre;
		this.clase = clase;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClaseEntity getClase() {
		return clase;
	}

	public void setClase(ClaseEntity clase) {
		this.clase = clase;
	}

	public Set<ProfesorEntity> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<ProfesorEntity> profesores) {
		this.profesores = profesores;
	}	
}
