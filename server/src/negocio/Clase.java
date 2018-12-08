package negocio;

import dao.ClaseDAO;
import dao.MateriaDAO;
import dto.ClaseDTO;
import dto.MateriaDTO;
import dto.ProfesorDTO;
import views.ClaseView;

import java.sql.Date;

public class Clase {
	
	private Materia materia;
	private Float horario;
	private String estado; //libre, pendiente, ocupada
	private Integer idClase;
	private Profesor profesor;
	private Date fecha;

	public Clase(Materia mat, Date fecha, Float horario, String estado, int numero, Profesor profesor) {
		this.materia = mat;
		this.estado = estado;
		this.idClase = idClase; //chequear esto
		this.profesor = profesor;
		this.horario = horario;
		this.fecha = fecha;
	}

	public Clase(Integer idClase2, Float horario2, String estado2, Profesor p) {
		this.idClase=idClase2;
	}

	public float getHorario() {
		return horario;
	}
	public void setHorario(float horario) {
		this.horario = horario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getNumero() {
		return idClase;
	}
	
	public void setNumero(int numero) {
		this.idClase = numero;
	}
	
	public Integer getIdClase() {
		return idClase;
	}

	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setHorario(Float horario) {
		this.horario = horario;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void agregarProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public Materia getMateria() {
		return materia;
	}
	
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public boolean sosClaseMateria(Materia materia) {
		return (this.materia==materia);
	}
	
	public boolean sosClaseNro(int numero) {
		return (this.idClase==numero);
	}

	public void save() {
		ClaseDAO.getInstancia().agregarClase(this);
		ClaseDAO.getInstancia().agregarMateria(this);
	}

	public ClaseDTO DTO() {
		ClaseDTO dto=new ClaseDTO(materia.getNombre(), horario, estado, idClase, profesor.getDni());
		return dto;
	}
}
