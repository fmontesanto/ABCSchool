package dto;

import java.util.Date;

public class FacturaDTO {
	private float monto;
	private String tipo;
	private String remitente;
	private String medioPago;
	private int numero;
	private Date fecha;
	
	public FacturaDTO(float monto, String tipo, String remitente, String medioPago,int numero, Date fecha) {
		this.monto=monto;
		this.tipo=tipo;
		this.remitente=remitente;
		this.medioPago=medioPago;
		this.numero=numero;
		this.fecha=fecha;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public float getMonto() {
		return monto;
	}
	public String getTipo() {
		return tipo;
	}
	public String getRemitente() {
		return remitente;
	}
	public String getMedioPago() {
		return medioPago;
	}
	public int getNumero() {
		return numero;
	}

}
