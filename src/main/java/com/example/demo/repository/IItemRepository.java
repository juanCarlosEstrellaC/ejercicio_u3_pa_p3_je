package com.example.demo.repository;

import com.example.demo.modelo.Item;

public interface IItemRepository {

	public void ingresarItem(Item item);
	public Item buscarCodigoBarras(Integer codigoBarras);
	public Long obtenerNumeroItemsBuscadoCodigoBarras(Integer codigoBarras);
	public int actualizarPorCodigoBarras(Integer codigoBarras, Integer stock);
	
	
}
