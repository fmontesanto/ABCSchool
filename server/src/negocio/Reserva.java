package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.Factura;
import dao.FacturaDAO;
import dao.ReservaDAO;
import dto.ClaseDTO;
import dto.ReservaDTO;
import views.ReservaView;

public class Reserva {
	
	private Integer idReserva;
	private Float descuento;
	private Float monto;
	private Integer cantAlum;
	private boolean paga;
	private Date fecha;
	private Alumno alumno;
	private Factura factura;
	private ArrayList<Clase> clases;
	
	public Reserva(Integer idReserva, Float descuento, Float monto, Integer cantAlum, boolean paga,
			Date fecha, Alumno alumno) {
		super();
		this.idReserva = idReserva;
		this.descuento = descuento;
		this.monto = monto;
		this.cantAlum = cantAlum;
		this.paga = paga;
		this.fecha = fecha;
		this.clases = new ArrayList<Clase>();
		this.alumno = alumno;
		this.factura=null;
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

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public void addClase(Clase clase) {
		this.clases.add(clase);
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
	
	public ReservaView toView(){
		return new ReservaView(idReserva, descuento, monto, cantAlum, paga, fecha, alumno.getDni(), factura.getNumero());
	}
	
	public void generarFactura (Date fechaActual,String tipo,String remitente,String medioPago) {

		Factura factura=new Factura( fechaActual,monto, tipo, remitente, medioPago, 0,this);
		factura.save();
		this.factura=factura;
		this.update();
		
	}
	
	public void calcularMontoTotal() {
		float total=0;
		for (Clase clase:clases) {
			total=+clase.getMonto();//TODO 
		}
		total=total*(1-descuento);
		this.monto=total;
	}
	
	public void save() {
		ReservaDAO.getInstancia().agregarReserva(this);
	}
	public void update() {
		ReservaDAO.getInstancia().completarReserva(this);
	}
	public void delete() {
		ReservaDAO.getInstancia().cancelarReserva(this.getIdReserva());
	}
	private ArrayList<ClaseDTO>clases2dto(){
		ArrayList<ClaseDTO> clasesDTO=new ArrayList<ClaseDTO>(); 
		for(Clase clase:clases) {
			ClaseDTO claseDto=clase.DTO();
			clasesDTO.add(claseDto);
		}
		return clasesDTO;
	}
	public ReservaDTO DTO() {
		ArrayList<ClaseDTO>clasesdto=clases2dto();
		ReservaDTO dto=new ReservaDTO(idReserva,descuento,monto,cantAlum,paga,fecha,alumno,factura.DTO(),clasesdto);
		return dto;
	}
}
