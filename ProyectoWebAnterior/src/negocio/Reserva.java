package negocio;

import java.util.ArrayList;

public class Reserva {

	private int codigo;
	private float descuento;
	private float monto;
	private int cantAlumnos;
	private float duracion;
	private boolean paga;
	private ArrayList<Clase> clases;
	
	public Reserva(int codigo, float descuento, float monto, int cantAlumnos, float duracion, boolean paga) {
		super();
		this.codigo = codigo;
		this.descuento = descuento;
		this.monto = monto;
		this.cantAlumnos = cantAlumnos;
		this.duracion = duracion;
		this.paga = paga;
		this.clases = new ArrayList<Clase>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public int getCantAlumnos() {
		return cantAlumnos;
	}

	public void setCantAlumnos(int cantAlumnos) {
		this.cantAlumnos = cantAlumnos;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}
	
	public void agregarClase(Clase clase) {
		clases.add(clase);
	}

}
