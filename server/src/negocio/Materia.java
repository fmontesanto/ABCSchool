package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.MateriaDAO;
import dto.MateriaDTO;
import entities.MateriaEntity;
import views.MateriaView;

public class Materia {

	private String nombre;
	private Integer idMateria;
	private List<Profesor> profesores;
	private List<Clase> clases;
	
	public Materia(String nombre, Integer idMateria) {
		super();
		this.nombre = nombre;
		this.idMateria = idMateria;
	}
	
	public Materia(String nombre, Integer idMateria, List<Clase> clases) {
		super();
		this.nombre = nombre;
		this.idMateria = idMateria;
		this.profesores = new ArrayList<Profesor>();
		this.clases = clases;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClase(List<Clase> clases) {
		this.clases = clases;
	}
	
	public MateriaView toView(){
		return new MateriaView(nombre, idMateria);
	}
	public void save() {
		MateriaDAO.getInstancia().agregarMateria(this);
	}
/*	public void update() {
		MateriaDAO.getInstancia().update(this);
	}*/

	public MateriaDTO toDTO() {
		MateriaDTO dto=new MateriaDTO(nombre,idMateria);
		return dto;
	}


}

