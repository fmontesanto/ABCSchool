package views;

import java.util.ArrayList;
import java.util.Date;

import negocio.Resena;

public class ProfesorView extends UsuarioView{
	private float anticipacionReserva;
	private float puntuacion;
	private ArrayList<ResenaView> resenasView;
	
	public ProfesorView(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String contra, String domicilioClases,float anticipacion,ArrayList<Resena> resenas) {
		super(dni, nombre, mail, telefono, domicilio, fechaNacimiento, contra);
		this.anticipacionReserva=anticipacion;
		this.domicilioClases=domicilioClases;
		this.resenasView=resenas2View(resenas);
	}
	private String domicilioClases;
	public String getDomicilioClases() {
		return domicilioClases;
	}
	public float getAnticipacionReserva() {
		return anticipacionReserva;
	}
	public float getPuntuacion() {
		return puntuacion;
	}
	public ArrayList<ResenaView> getResenas() {
		return resenasView;
	}
	public ArrayList<ResenaView> resenas2View(ArrayList<Resena> resenas){
		ArrayList<ResenaView> resenasView=new ArrayList<ResenaView>();
		for (Resena resena:resenas) {
			ResenaView rv=resena.getView();
			resenasView.add(rv);
		}
		return resenasView;
	}
	
}
