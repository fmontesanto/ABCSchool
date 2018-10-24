package entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idUsuario")
	private Integer idUsuario;
	@Column(name="dni")
	private String dni;
	@Column(name="nombre")
	private String nombre;
	@Column(name="mail")
	private String mail;
	@Column(name="telefono")
	private String telefono;
	@Column(name="domicilio")
	private String domicilio;
	@Column(name="fechaNacimiento")
	private String fechaNacimiento;
	@Column(name="password")
	private String password;
	
	public UsuarioEntity(String dni, String nombre, String mail, String telefono, String domicilio,
			String fechaNacimiento, String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.mail = mail;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
