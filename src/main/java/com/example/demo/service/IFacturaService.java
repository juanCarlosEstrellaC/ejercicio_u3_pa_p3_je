package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.dto.ItemDto;

public interface IFacturaService {
	
	public void realizarFactura(List<ItemDto> listaItemsSimples, String cedula, Integer numero );
	

}
