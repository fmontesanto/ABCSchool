package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {
	
	private Integer idReserva;
	private Float descuento;
	private Float monto;
	private Integer cantAlum;
	private Float duracion;
	private boolean paga;
	private Date fecha;
	private Alumno alumno;
	private Factura factura;
	private List<Clase> clases;
	
	public Reserva(Integer idReserva, Float descuento, Float monto, Integer cantAlum, Float duracion, boolean paga,
			Date fecha, Alumno alumno, Factura factura) {
		super();
		this.idReserva = idReserva;
		this.descuento = descuento;
		this.monto = monto;
		this.cantAlum = cantAlum;
		this.duracion = duracion;
		this.paga = paga;
		this.fecha = fecha;
		this.clases = new ArrayList<Clase>();
		this.alumno = alumno;
		this.factura = factura;
	}
	
	public boolean sosReserva(Integer id){
		return idReserva == id;
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

	public Float getDuracion() {
		return duracion;
	}

	public void setDuracion(Float duracion) {
		this.duracion = duracion;
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

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	/*public Float controlaFecha(){ HACER
	
	}*/

	public void eliminarse(){
		
	}

}
