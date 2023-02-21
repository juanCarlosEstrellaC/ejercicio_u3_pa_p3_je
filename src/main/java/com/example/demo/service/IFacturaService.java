package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.dto.ItemDto;

public interface IFacturaService {
	
	public void realizarFactura(List<ItemDto> listaItemsSensillos, String cedula, Integer numeroVenta);
	public Factura buscarPorNumero(Integer numero);
	

}
