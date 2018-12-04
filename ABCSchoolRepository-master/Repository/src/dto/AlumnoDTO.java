package dto;

import java.util.ArrayList;
import java.util.Date;

import negocio.Reserva;

public class AlumnoDTO extends UsuarioDTO{
	private float saldoAFavor;
	private ArrayList<ReservaDTO> reservas;
	
	public AlumnoDTO(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password,float saldoAFavor,ArrayList<ReservaDTO> reservas) {
		super( dni,  nombre,  mail,  telefono, domicilio, fechaNacimiento, password);
		this.saldoAFavor=saldoAFavor;
		this.setReservas(reservas);	
	}

	public float getSaldoAFavor() {
		return saldoAFavor;
	}
	public void setSaldoAFavor(float saldo) {
		this.saldoAFavor=saldo;
	}

	public ArrayList<ReservaDTO> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<ReservaDTO> reservas) {
		this.reservas = reservas;
	}
	
}
