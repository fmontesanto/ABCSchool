package views;

import java.util.Date;

public abstract class UsuarioView {
	protected String dni;
	protected String nombre;
	protected String mail;
	protected String telefono;
	protected String domicilio;
	protected Date fechaNacimiento;
	protected String password;
	
	public UsuarioView(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) {
		this.dni=dni;
		this.nombre=nombre;
		this.mail=mail;
		this.telefono=telefono;
		this.domicilio=domicilio;
		this.fechaNacimiento=fechaNacimiento;
		this.password=password;
	}
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMail() {
		return mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getPassword() {
		return password;
	}
	
	
}
