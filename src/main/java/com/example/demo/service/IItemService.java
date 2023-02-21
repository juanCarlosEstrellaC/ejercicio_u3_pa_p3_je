package com.example.demo.service;

import com.example.demo.modelo.Item;

public interface IItemService {

	public void ingresarItem(Item item);
	public Integer obtenerNumeroStock(Integer codigoBarras);
	public Item metodoBuscarCodigoBarras(Integer codigoABuscar);
	
}
