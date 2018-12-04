package dto;


public class ClaseDTO {
	private MateriaDTO materia;
	private Float horario;
	private String estado;
	private Integer idClase;
	private ProfesorDTO profesor;
	
	public ClaseDTO(MateriaDTO materia, Float horario, String estado, Integer idClase, ProfesorDTO profesor) {
		this.materia=materia;
		this.horario=horario;
		this.estado=estado;
		this.idClase=idClase;
		this.profesor=profesor;
	}
	
	public float getHorario() {
		return horario;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public int getIdClase() {
		return idClase;
	}
	
	public ProfesorDTO getProfesor() {
		return profesor;
	}
	
	public MateriaDTO getMateria() {
		return materia;
	}

	public void setMateria(MateriaDTO materia) {
		this.materia = materia;
	}

	public void setHorario(Float horario) {
		this.horario = horario;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	public void setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
	}

}
