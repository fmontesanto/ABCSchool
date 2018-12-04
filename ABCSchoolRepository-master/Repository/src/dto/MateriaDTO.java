package dto;

public class MateriaDTO {
	
	private String nombre;
	private Integer idMateria;
	
	public MateriaDTO(String nombre, Integer idMateria) {
		super();
		this.nombre = nombre;
		this.idMateria = idMateria;
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
}
