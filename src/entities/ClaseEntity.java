package entities;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//import negocio.Articulo.Estado;

@Entity
@Table(name="Clase")
public class ClaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idClase")
	private Integer idClase;
	@Column(name="materia")
	private String materia;
	@Column(name="horario")
	private Float horario;
	@Column(name="estado")
	private String estado;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="idCodigoDeBarra")
	private CodigoDeBarraEntity codigoDeBarra;
	
	@OneToMany(mappedBy="articulo",cascade = CascadeType.ALL)
	private List<LoteEntity> lotes;
	
	@OneToMany(mappedBy="articulo",cascade=CascadeType.ALL)
	private List<ItemUbicacionEntity > itemsUbicacion;
	
	 /*@ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "ItemUbicacion", 
	        joinColumns = { @JoinColumn(name = "idArticulo") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idUbicacion") } )
	    Set<Ubicacion> ubicaciones = new HashSet<>();*/
	
	
	

	public ArticuloEntity() {}

	public ArticuloEntity(String codigo, String nombre, String marca, String tipo, String subtipo,
			String descripcion, String proveedor, int estado,Float costo, float precio, int cantidadActual,
			int cantidadMinimaDeseada, boolean medioIVA,CodigoDeBarraEntity codigoBarra) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.descripcion = descripcion;
		this.proveedor = proveedor;
		//this.imagen = imagen;
		this.estado = estado;
		setCosto(costo);
		this.precio = precio;
		this.cantidadActual = cantidadActual;
		this.cantidadMinimaDeseada = cantidadMinimaDeseada;
		this.medioIVA = medioIVA;
		this.setCodigoDeBarra(codigoBarra);
	}

	
	public CodigoDeBarraEntity getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(CodigoDeBarraEntity codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	public String getCodigo()
	{
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSubtipo() {
		return subtipo;
	}

	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

/*	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}*/

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public int getCantidadMinimaDeseada() {
		return cantidadMinimaDeseada;
	}

	public void setCantidadMinimaDeseada(int cantidadMinimaDeseada) {
		this.cantidadMinimaDeseada = cantidadMinimaDeseada;
	}

	public boolean isMedioIVA() {
		return medioIVA;
	}

	public void setMedioIVA(boolean medioIVA) {
		this.medioIVA = medioIVA;
	}
	
	public void agregarLote(LoteEntity l) {
		lotes.add(l);
	}
	
	public void agregarItems(ItemUbicacionEntity i) {
		itemsUbicacion.add(i);
	}
	
	public List<LoteEntity> getLotes() {
		return lotes;
	}

	public void setLotes(List<LoteEntity> lotes) {
		this.lotes = lotes;
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
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}*/
	

}
