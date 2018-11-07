package entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Factura")
public class FacturaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="nroFactura")
	private Integer nroFactura;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="monto")
	private Float monto;
	@Column(name="tipo")
	private String tipo;
	@Column(name="remitente")
	private String remitente;
	@Column(name="medioPago")
	private String medioPago;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="idReserva")
	private ReservaEntity reserva;
	
	
	public FacturaEntity() {}


	public FacturaEntity(Date fecha, Float monto, String tipo, String remitente, String medioPago,
			ReservaEntity reserva) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.tipo = tipo;
		this.remitente = remitente;
		this.medioPago = medioPago;
		this.reserva = reserva;
	}

	public Integer getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Integer nroFactura) {
		this.nroFactura = nroFactura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
}
