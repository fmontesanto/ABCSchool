package dto;

import java.util.ArrayList;
import java.util.Date;

public class ReservaDTO {
	
	private Integer idReserva;
	private Float descuento;
	private Float monto;
	private Integer cantAlum;
	private boolean paga;
	private Date fecha;
	private AlumnoDTO alumno;
	private FacturaDTO factura;
	

	public ReservaDTO(Integer idReserva2, Float descuento2, Float monto2, Integer cantAlum2, boolean paga2, Date fecha2,
			AlumnoDTO alumno2, FacturaDTO factura2, ArrayList<ClaseDTO> clases) {
		super();
		this.idReserva = idReserva2;
		this.descuento = descuento2;
		this.monto = monto2;
		this.cantAlum = cantAlum2;
		this.paga = paga2;
		this.fecha = fecha2;
		this.alumno = alumno2;
		this.factura = factura2;
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

	public AlumnoDTO getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoDTO alumno) {
		this.alumno = alumno;
	}

	public FacturaDTO getFactura() {
		return factura;
	}

	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}
}
