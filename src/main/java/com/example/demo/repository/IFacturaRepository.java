package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.dto.ItemDto;

public interface IFacturaRepository {

	public void realizarFactura(List<ItemDto> listaItemsSimples, String cedula, Integer numero );
}
