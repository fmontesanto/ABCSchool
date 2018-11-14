package entities;

import java.util.ArrayList;
import java.util.Date;
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
			Date fechaNacimiento, String password) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		this.saldoAFavor = 0f;
		this.reservas = new ArrayList<ReservaEntity>();
	}
	
	public AlumnoEntity(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password, Float saldo, List<ReservaEntity> reservas) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		this.saldoAFavor = saldo;
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
