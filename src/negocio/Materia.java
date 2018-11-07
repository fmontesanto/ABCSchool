package negocio;

import java.util.ArrayList;
import java.util.List;

public class Materia {

	private String nombre;
	private Integer idMateria;
	private List<Profesor> profesores;
	private List<Clase> Clase;
	
	public Materia(String nombre, Integer idMateria, List<Profesor> profesores, List<negocio.Clase> clase) {
		super();
		this.nombre = nombre;
		this.idMateria = idMateria;
		this.profesores = new ArrayList<Profesor>();
		Clase = clase;
	}
	
	
	
}
