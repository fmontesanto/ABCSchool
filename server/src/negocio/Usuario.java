package negocio;

import java.util.Date;

public abstract class Usuario {
	protected String dni;
	protected String nombre;
	protected String mail;
	protected String telefono;
	protected String domicilio;
	protected Date fechaNacimiento;
	protected String contra;
	protected Integer idUsuario;
	
	public Usuario(int idUsuario,String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra) {
		this.idUsuario=idUsuario;
		this.dni=dni;
		this.nombre=nombre;
		this.mail=mail;
		this.telefono=telefono;
		this.domicilio=domicilio;
		this.fechaNacimiento=fechaNacimiento;
		this.contra=contra;
	}
	public Usuario(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra) {
		this.dni=dni;
		this.nombre=nombre;
		this.mail=mail;
		this.telefono=telefono;
		this.domicilio=domicilio;
		this.fechaNacimiento=fechaNacimiento;
		this.contra=contra;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra=contra;
	}
	
	public String getDni() {
		return dni;
		
	}

}
