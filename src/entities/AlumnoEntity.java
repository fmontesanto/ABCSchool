package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Alumno")
public class AlumnoEntity extends UsuarioEntity {
	
	@Column(name="saldoAFavor")
	private Float saldoAFavor;
	
	@OneToMany(mappedBy="alumno", cascade=CascadeType.ALL)
	private List<ReservaEntity> reservas;

	public AlumnoEntity() {}

	public AlumnoEntity(String dni, String nombre, String mail, String telefono, String domicilio,
			String fechaNacimiento, String password, Float saldoAFavor, List<ReservaEntity> reservas) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		this.saldoAFavor = saldoAFavor;
		this.reservas = reservas;
	}

	public Float getSaldoAFavor() {
		return saldoAFavor;
	}

	public void setSaldoAFavor(Float saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}

	public List<ReservaEntity> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaEntity> reservas) {
		this.reservas = reservas;
	}	
}
