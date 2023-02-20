package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
//@NamedNativeQuery(name = "Item.buscarCodigoBarras", query = " SELECT i.nombre FROM item i WHERE i.item_codigo_barras = :datoCodigo")
@NamedNativeQuery(name = "Item.buscarCodigoBarras", query = "SELECT * FROM item i WHERE i.item_codigo_barras = :datoCodigo") 

@NamedNativeQuery(name = "Item.obtenerNumeroItems", query = "SELECT COUNT(*) FROM item i WHERE i.item_codigo_barras = :datoCodigo") 
																																		
//@NamedNativeQuery(name = "Item.actuaizarPorCodigoBarras", query = "UPDATE item i SET i.stock = :datoStock WHERE i.item_codigo_barras = :datoCodigo")
@NamedNativeQuery(name = "Item.actualizarPorCodigoBarras", query = "UPDATE item  SET item_stock = :datoStock  WHERE  item_codigo_barras = :datoCodigo")

public class Item { //PRODUCTO

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1) 
	@Column(name = "item_Id")
	private Integer id;
	
	@Column(name = "item_codigo_barras")
	private Integer codigoBarras;
	
	@Column(name = "item_nombre")
	private String nombre;
	
	@Column(name = "item_tipo")
	private String tipo;
	
	@Column(name = "item_stock")
	private Integer stock;
	
	@Column(name = "item_precio")
	private BigDecimal precio;
	
	@OneToMany(mappedBy = "miItem", cascade = CascadeType.ALL)
	private List<DetalleFactura> miListaDetallesItem;

	//toString
	@Override
	public String toString() {
		return "Item [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", stock=" + stock + ", precio=" + precio + "]";
	}
	
	// Get y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Integer codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getMiListaDetallesItem() {
		return miListaDetallesItem;
	}

	public void setMiListaDetallesItem(List<DetalleFactura> miListaDetallesItem) {
		this.miListaDetallesItem = miListaDetallesItem;
	}


	
	
	
	
	
	
	
}
