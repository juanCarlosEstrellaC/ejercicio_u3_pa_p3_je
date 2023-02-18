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

		Item itemBuscado = this.iItemRepository.buscarCodigoBarras(123);
		
		if (itemBuscado == null) {
			itemBuscado.setStock(1);
			this.iItemRepository.ingresarItem(itemBuscado);

		} else {
			this.iItemRepository.actualizarPorCodigoBarras(itemBuscado.getCodigoBarras(), itemBuscado.getStock() + 1);
		}
		
	}

}
