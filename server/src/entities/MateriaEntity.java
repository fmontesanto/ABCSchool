package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.Clase;
import negocio.Materia;


@Entity
@Table(name="Materia")
public class MateriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idMateria")
	private Integer idMateria;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="materia", cascade=CascadeType.ALL)
	private List<ClaseEntity> clases;
	
	@ManyToMany
    @JoinTable(
        name = "MateriaProfesor", 
        joinColumns = { @JoinColumn(name = "idMateria") }, 
        inverseJoinColumns = { @JoinColumn(name = "idUsuario") } )
    Set<ProfesorEntity> profesores = new HashSet<ProfesorEntity>();

	public MateriaEntity(){}
	
	public MateriaEntity(String nombre, List<ClaseEntity> clases, Set<ProfesorEntity> profesores) {
		super();
		this.nombre = nombre;
		this.clases = clases;
		this.profesores = profesores;
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

	public List<ClaseEntity> getClases() {
		return clases;
	}

	public void setClases(List<ClaseEntity> clases) {
		this.clases = clases;
	}

	public Set<ProfesorEntity> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<ProfesorEntity> profesores) {
		this.profesores = profesores;
	}	
	public Materia toMateria(){
		List<Clase> clases = new ArrayList<Clase>();
		for(ClaseEntity c : this.clases){
			clases.add(c.toClase());
		}
		return new Materia(nombre, idMateria, clases);
	}
}
