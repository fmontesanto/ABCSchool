package negocio;

import java.util.Date;

import views.FacturaView;

public class Factura {
	private Date fecha;
	private Float monto;
	private String tipo;
	private String remitente;
	private String medioPago;
	private Integer nroFactura;
	
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
	public FacturaView getView() {
		FacturaView factura=new FacturaView(monto, medioPago, medioPago, medioPago, nroFactura, fecha);
		return factura;
	}
	

}
