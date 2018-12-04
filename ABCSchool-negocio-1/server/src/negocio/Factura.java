package negocio;

import java.util.Date;

import dao.FacturaDAO;
import dto.FacturaDTO;
import views.FacturaView;

public class Factura {

	private Date fecha;
	private Float monto;
	private String tipo;
	private String remitente;
	private String medioPago;
	private Integer nroFactura;
	private Reserva reserva;
	
	
	public Factura(Date fecha, Float monto, String tipo, String remitente, String medioPago, Integer nroFactura,
			Reserva reserva) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.tipo = tipo;
		this.remitente = remitente;
		this.medioPago = medioPago;
		this.nroFactura = nroFactura;
		this.reserva = reserva;
	}
	public int getNumero() {
		return nroFactura;
	}
	public void setNumero(int numero) {
		this.nroFactura = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
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
	public boolean sosFactura(int numero) {
		return this.nroFactura==numero;
	}
	
	public Reserva getReserva() {
		return reserva;
	}
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public void save() {
		FacturaDAO.getInstancia().agregarFactura(this);
	}
	public FacturaDTO DTO() {
		FacturaDTO dto=new FacturaDTO(monto, tipo, remitente, medioPago,nroFactura, fecha);
		return dto;
	}
}
