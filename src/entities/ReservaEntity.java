package entities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reserva")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idReserva")
	private Integer idReserva;
	@Column(name="descuento")
	private Float descuento;
	@Column(name="monto")
	private Float monto;
	@Column(name="cantAlum")
	private Integer cantAlum;
	@Column(name="paga")
	private boolean paga;
	@Column(name="fecha")
	private Date fecha;

	@OneToMany
	@JoinColumn(name="idReserva")
	private List<ClaseEntity> clases;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="nroFactura")
	private FacturaEntity factura;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name="idUsuario")
	protected AlumnoEntity alumno;

	public ReservaEntity() {}
	
	public ReservaEntity(Float descuento, Float monto, Integer cantAlum, boolean paga, Date fecha,
			List<ClaseEntity> clases, AlumnoEntity alumno) {
		super();
		this.descuento = descuento;
		this.monto = monto;
		this.cantAlum = cantAlum;
		this.paga = paga;
		this.fecha = fecha;
		this.clases = clases;
		this.alumno = alumno;
	}

	public ReservaEntity(Float descuento, Float monto, Integer cantAlum, boolean paga, Date fecha,
			List<ClaseEntity> clases, FacturaEntity factura, AlumnoEntity alumno) {
		super();
		this.descuento = descuento;
		this.monto = monto;
		this.cantAlum = cantAlum;
		this.paga = paga;
		this.fecha = fecha;
		this.clases = clases;
		this.factura = factura;
		this.alumno = alumno;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Float getDescuento() {
		return descuento;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Integer getCantAlum() {
		return cantAlum;
	}

	public void setCantAlum(Integer cantAlum) {
		this.cantAlum = cantAlum;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<ClaseEntity> getClases() {
		return clases;
	}

	public void setClases(List<ClaseEntity> clases) {
		this.clases = clases;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}

	public AlumnoEntity getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoEntity alumno) {
		this.alumno = alumno;
	}
	
	public Float controlarFecha(){
		Date fechaFinal= Calendar.getInstance().getTime();
 		int dias=(int) ((fechaFinal.getTime()-fecha.getTime())/86400000);
 		if(dias >=2)
 			return monto;
 		else 
 			return -1f;
 	}
}

