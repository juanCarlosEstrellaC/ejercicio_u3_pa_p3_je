package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.DetalleFactura;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Item;
import com.example.demo.modelo.dto.ItemDto;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IItemService;

@SpringBootApplication
public class EjercicioU3PaP3JeApplication implements CommandLineRunner{

	@Autowired
	private IItemService iItemService;
	
	@Autowired 
	private IFacturaService iFacturaService;

	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP3JeApplication.class, args);
	}

	/**
	 1. Si es native, ver los nombres de las columnas en el PgAdmin para no pifiar poniendo otros.
	 2. Aprender bien los querys, xq en actualizar devuelve un entero.
	 3. El método retorna un objeto de Item, y yo le pongo en el SQL que retorne un String, porque pongo SELECT i.item_nombre FROM...
	 3.1. Al final, tuve que usar un Long para ver el número de elementos de la DB en la tabla Item.
	 4. En el UPDATE, el SQL no usa ALIAS, tipo "item i", no funciona así como en el SELECT.
	 5. Un error en la lógica: estaba actualizando el stock de un item que no existía.
	 6. En los NamedNative, poner el parámetro resultClass. Pero cuando regresa un Long, no vale ponerle Long.class; se cae.
	 */
	// 1h10 literal a, sin hacer modelos.
	@Override
	public void run(String... args) throws Exception {
		
	// literal a)
		System.out.println(" ***************** Literal A *****************");
		Item miItem = new Item();
		miItem.setCodigoBarras(963);
		miItem.setNombre("Comedor");
		miItem.setPrecio(new BigDecimal(89.25));
		miItem.setTipo("hogar");
		miItem.setStock(200);
		
		this.iItemService.ingresarItem(miItem);
		System.out.println("");
	
		
	// literal b)
		System.out.println(" ***************** Literal B *****************");
		List<ItemDto> listaItemsDTO = new ArrayList<>();
		ItemDto dto1 = new ItemDto(123, 7);
		listaItemsDTO.add(dto1);
		
		ItemDto dto2 = new ItemDto(456, 11);
		listaItemsDTO.add(dto2);

		ItemDto dto3 = new ItemDto(789, 20);
		listaItemsDTO.add(dto3);

		ItemDto dto4 = new ItemDto(963, 20);
		listaItemsDTO.add(dto4);
		
		Integer numeroFactura = 16;
		this.iFacturaService.realizarFactura(listaItemsDTO, "1234568", numeroFactura);
		
		// Imprimir la factura:
		Factura factura = this.iFacturaService.buscarPorNumero(numeroFactura);
		System.out.println(factura);
		for (DetalleFactura detalle : factura.getMiListaDetallesFact()) {
			System.out.println(detalle);
		}
		
		// literal c)
		System.out.println(" ***************** Literal C *****************");
		Integer stockBuscado = this.iItemService.obtenerNumeroStock(456);
		System.out.println(stockBuscado+"\n");

	}
	
}
