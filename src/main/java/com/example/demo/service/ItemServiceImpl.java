package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Item;
import com.example.demo.repository.IItemRepository;

@Service
public class ItemServiceImpl implements IItemService{

	@Autowired
	private IItemRepository iItemRepository;
	
	@Override
	public void ingresarItem(Item item) {
		
		// 1. Busco si el item ya existe:
		Integer codigoABuscar = item.getCodigoBarras();
		Long numeroItems = this.iItemRepository.obtenerNumeroItemsBuscadoCodigoBarras(codigoABuscar);		
		
		// Si No existe, lo ingreso:
		if (numeroItems == 0) {
			System.out.println("Item de primer ingreso");
			this.iItemRepository.ingresarItem(item);
		} else { //Sino, actualizo por Codigo de Barras:
			System.out.println("Actualizar el Stock");
			Item itemBuscado = this.iItemRepository.buscarCodigoBarras(codigoABuscar);
			this.iItemRepository.actualizarPorCodigoBarras(itemBuscado.getCodigoBarras(), itemBuscado.getStock()+item.getStock());
		}

		
	}

	@Override
	public Integer obtenerNumeroStock(Integer codigoBarras) {
		Long numeroItems = this.iItemRepository.obtenerNumeroItemsBuscadoCodigoBarras(codigoBarras);
		Integer auxiliar = 0;
		
		if (numeroItems == 0) {
			System.out.println("No existe dicho código de barras. Cantidad de elementos:");
		} else {
			auxiliar =  this.iItemRepository.obtenerNumeroStock(codigoBarras);
			System.out.println("Cantidad de elementos:");
		}
		
		return auxiliar;
	}

}
