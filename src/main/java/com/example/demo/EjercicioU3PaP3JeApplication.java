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

	/**
	 1. Si es native, ver los nombres de las columnas en el PgAdmin para no pifiar poniendo otros.
	 2. Aprender bien los querys, xq en actualizar devuelve un entero.
	 3. El método retorna un objeto de Item, y yo le pongo en el SQL que retorne un String, porque pongo SELECT i.item_nombre FROM...
	 3.1. Al final, tuve que usar un Long para ver el número de elementos de la DB en la tabla Item.
	 4. En el UPDATE, el SQL no usa ALIAS, tipo "item i", no funciona así como en el SELECT.
	 */
	// 1h10 literal a, sin hacer modelos.
	@Override
	public void run(String... args) throws Exception {
		
		Item miItem = new Item();
		miItem.setCodigoBarras(456);
		miItem.setNombre("Martillo");
		miItem.setPrecio(new BigDecimal(5.5));
		miItem.setTipo("hogar");
		miItem.setStock(4);
		
		this.iItemService.ingresarItem(miItem);
		
		//List<ItemDto> ite = new ArrayList<>();
		
		//this.iFacturaService.realizarFactura(ite, "1234568", 1);
		
		
		
		
	}

}
