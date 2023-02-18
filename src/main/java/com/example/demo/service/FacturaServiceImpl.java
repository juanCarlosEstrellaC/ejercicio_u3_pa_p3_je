package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.dto.ItemDto;
import com.example.demo.repository.IFacturaRepository;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Override
	public void realizarFactura(List<ItemDto> listaItemsSimples, String cedula, Integer numero) {
		this.iFacturaRepository.realizarFactura(listaItemsSimples, cedula, numero);
	}

}
