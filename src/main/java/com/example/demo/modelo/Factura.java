package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_seq")
	@SequenceGenerator(name = "fact_seq", sequenceName = "fact_seq", allocationSize = 1) 
	@Column(name = "fact_Id")
	private Integer id;
	
	@Column(name = "fact_numero")
	private Integer numero;
	
	@Column(name = "fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "fact_cedula_cliente")
	private String cedulaCliente;
	
	@Column(name = "fact_total_venta")
	private BigDecimal totalVenta;
	
	@OneToMany(mappedBy = "miFactura", cascade = CascadeType.ALL)
	private List<DetalleFactura> miListaDetallesFact;

	//toString
	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedulaCliente=" + cedulaCliente
				+ ", totalVenta=" + totalVenta + "]";
	}

	
	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleFactura> getMiListaDetallesFact() {
		return miListaDetallesFact;
	}

	public void setMiListaDetallesFact(List<DetalleFactura> miListaDetallesFact) {
		this.miListaDetallesFact = miListaDetallesFact;
	}
	
	

}
