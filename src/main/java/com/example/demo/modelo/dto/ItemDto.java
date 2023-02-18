package com.example.demo.modelo.dto;

public class ItemDto {
	
	private Integer codigoBarras;
	private Integer stock;
	
	
	public ItemDto() {}

	public ItemDto(Integer codigoBarras, Integer stock) {
		super();
		this.codigoBarras = codigoBarras;
		this.stock = stock;
	}

	public Integer getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Integer codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	
	

}
