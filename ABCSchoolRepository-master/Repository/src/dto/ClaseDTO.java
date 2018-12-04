package dto;


public class ClaseDTO {
	private String materia;
	private Float horario;
	private String estado;
	private Integer idClase;
	private Integer profesor;
	
	public ClaseDTO(String materia, Float horario, String estado, Integer idClase, Integer profesor) {
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
	
	public Integer getProfesor() {
		return profesor;
	}
	
	public String getMateria() {
		return materia;
	}

}
