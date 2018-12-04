package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Clase")
public class ClaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idClase")
	private Integer idClase;
	@Column(name="horario")
	private Float horario;
	@Column(name="estado")
	private String estado;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name="idMateria")
	protected MateriaEntity materia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name="idUsuario")
	protected ProfesorEntity profesor;

	@ManyToOne
	@JoinColumn(name="idReserva", insertable=false, updatable=false)
	private ReservaEntity reserva;

	public ClaseEntity() {}

	public ClaseEntity(Float horario, String estado, ProfesorEntity profesor) {
		super();
		this.horario = horario;
		this.estado = estado;
		this.setProfesor(profesor);
	}


	public MateriaEntity getMateria() {
		return materia;
	}

	public void setMateria(MateriaEntity materia) {
		this.materia = materia;
	}

	public Integer getIdClase() {
		return idClase;
	}

	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	public Float getHorario() {
		return horario;
	}

	public void setHorario(Float horario) {
		this.horario = horario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ProfesorEntity getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorEntity profesor) {
		this.profesor = profesor;
	}

	public ReservaEntity getReserva() {
		return reserva;
	}

	public void setReserva(ReservaEntity reserva) {
		this.reserva = reserva;
	}
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(alto);
		result = prime * result + Float.floatToIntBits(ancho);
		result = prime * result + cantCompra;
		result = prime * result + cantUbicacion;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + Float.floatToIntBits(precioVenta);
		result = prime * result + ((presentacion == null) ? 0 : presentacion.hashCode());
		result = prime * result + Float.floatToIntBits(profundidad);
		result = prime * result + stock;
		result = prime * result + stockReservado;
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
		return result;
	}*/

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloEntity other = (ArticuloEntity) obj;
		if (Float.floatToIntBits(alto) != Float.floatToIntBits(other.alto))
			return false;
		if (Float.floatToIntBits(ancho) != Float.floatToIntBits(other.ancho))
			return false;
		if (cantCompra != other.cantCompra)
			return false;
		if (cantUbicacion != other.cantUbicacion)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (Float.floatToIntBits(precioVenta) != Float.floatToIntBits(other.precioVenta))
			return false;
		if (presentacion == null) {
			if (other.presentacion != null)
				return false;
		} else if (!presentacion.equals(other.presentacion))
			return false;
		if (Float.floatToIntBits(profundidad) != Float.floatToIntBits(other.profundidad))
			return false;
		if (stock != other.stock)
			return false;
		if (stockReservado != other.stockReservado)
			return false;
		if (unidad == null) {
			if (other.unidad != null)
				return false;
		} else if (!unidad.equals(other.unidad))
			return false;
		return true;
	}*/
}
