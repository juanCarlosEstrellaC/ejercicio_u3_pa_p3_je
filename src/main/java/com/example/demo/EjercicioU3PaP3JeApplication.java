package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Item;
import com.example.demo.modelo.dto.ItemDto;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IItemService;

@SpringBootApplication
public class EjercicioU3PaP3JeApplication implements CommandLineRunner{

	@Autowired
	private IItemService iItemService;
	
	@Autowired IFacturaService iFacturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP3JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Item miItem = new Item();
		miItem.setCodigoBarras(123);
		miItem.setNombre("Cocacola");
		miItem.setPrecio(new BigDecimal(2));
		miItem.setTipo("bebida");
		miItem.setStock(0);
		
		this.iItemService.ingresarItem(miItem);
		
		List<ItemDto> ite = new ArrayList<>();
		
		this.iFacturaService.realizarFactura(ite, null, null);
		
		
		
		
	}

}
