package views;

import java.util.Date;

public class ReservaView {
	
	private Integer idReserva;
	private Float descuento;
	private Float monto;
	private Integer cantAlum;
	private boolean paga;
	private Date fecha;
	private String alumno;
	private int factura;
	
	public ReservaView(Integer idReserva, Float descuento, Float monto, Integer cantAlum, boolean paga, Date fecha,
			String alumno, int factura) {
		super();
		this.idReserva = idReserva;
		this.descuento = descuento;
		this.monto = monto;
		this.cantAlum = cantAlum;
		this.paga = paga;
		this.fecha = fecha;
		this.alumno = alumno;
		this.factura = factura;
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

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

	public int getFactura() {
		return factura;
	}

	public void setFactura(int factura) {
		this.factura = factura;
	}
}
