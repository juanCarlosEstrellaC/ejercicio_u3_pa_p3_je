package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detallefactura")
public class DetalleFactura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detf_Id")
	@SequenceGenerator(name = "detf_Id", sequenceName = "detf_Id", allocationSize = 1) 
	@Column(name = "detf_Id")
	private Integer id;
	
	@Column(name = "detf_cantidad")
	private Integer cantidad;
	
	@Column(name = "detf_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name = "detf_subtotal")
	private BigDecimal subtotal;
	
	
	
	@ManyToOne
	@JoinColumn(name = "fact_id_item")
	private Item miItem;
	
	@ManyToOne
	@JoinColumn(name = "fact_id_factura")
	private Factura miFactura;

	//toString
	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subtotal=" + subtotal + ", miItem=" + miItem + ", miFactura=" + miFactura + "]";
	}

	//Get y set
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	public Item getMiItem() {
		return miItem;
	}


	public void setMiItem(Item miItem) {
		this.miItem = miItem;
	}


	public Factura getMiFactura() {
		return miFactura;
	}


	public void setMiFactura(Factura miFactura) {
		this.miFactura = miFactura;
	}
	
	
	


}
