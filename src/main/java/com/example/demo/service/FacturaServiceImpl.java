package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.DetalleFactura;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Item;
import com.example.demo.modelo.dto.ItemDto;
import com.example.demo.repository.IFacturaRepository;
import com.example.demo.repository.IItemRepository;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private IItemRepository iItemRepository;
	
	@Autowired
	private IItemService iItemService;
	
	@Override
	public void realizarFactura(List<ItemDto> listaItemsSensillos, String cedula, Integer numeroVenta) { //Realizar una venta
		
		// 1. Creo una factura
		Factura miFactura = new Factura();
		miFactura.setCedulaCliente(cedula);
		miFactura.setFecha(LocalDateTime.now());
		miFactura.setNumero(numeroVenta);
		
			// 1.1. Creo una lista de detalles para esta factura
			List<DetalleFactura> listaDetallesFact = new ArrayList<>();
			
			// 1.2. Por cada DTO, obtengo su Original y seteo un nuevo detalle de Factura:
			for (ItemDto itemDto : listaItemsSensillos) {
				Integer codBarr = itemDto.getCodigoBarras();
				Item itemOriginal = this.iItemService.metodoBuscarCodigoBarras(codBarr);
				
				if (itemOriginal != null) {

					DetalleFactura detalleFact = new DetalleFactura();
					detalleFact.setCantidad(100);
					detalleFact.setMiItem(itemOriginal);
					detalleFact.setPrecioUnitario(itemOriginal.getPrecio());
					
						BigDecimal cant = new BigDecimal(detalleFact.getCantidad());
						BigDecimal subtotal = itemOriginal.getPrecio().multiply(cant);
					
					detalleFact.setSubtotal(subtotal);
					detalleFact.setMiFactura(miFactura);
	
					listaDetallesFact.add(detalleFact);
				}
			}
			
		// 2. Teniendo la lista de detalles con productos que existen, le añado a mi factura: 	
		miFactura.setMiListaDetallesFact(listaDetallesFact);
		
		// 3. Para cada Item de mi detalle, verifico si la cantidad a vender es mayor que el stock; si es así, se vende todo el stock.
		BigDecimal totalVendido = new BigDecimal(0);
		for (DetalleFactura detalleFactura : listaDetallesFact) {

			if (detalleFactura.getCantidad().compareTo(detalleFactura.getMiItem().getStock()) == 1) {
				System.out.println("La cantidad es mayor al stock del producto. Se venden todos los productos.");
				this.iItemRepository.actualizarPorCodigoBarras(detalleFactura.getMiItem().getCodigoBarras(), 0);
			} else {
				System.out.println("Se venden "+detalleFactura.getCantidad()+" items de "+detalleFactura.getMiItem().getNombre());
				Integer stockActualItem = detalleFactura.getMiItem().getStock();
				this.iItemRepository.actualizarPorCodigoBarras(detalleFactura.getMiItem().getCodigoBarras(), stockActualItem - detalleFactura.getCantidad());
			}
			System.out.println("############################"+detalleFactura.getSubtotal());
			totalVendido.add(detalleFactura.getSubtotal());
			System.out.println("***************************"+totalVendido);

		}
		
		// 4. Obtengo el total de la venta:
		System.out.println("---------------------------------"+ totalVendido);
		miFactura.setTotalVenta(totalVendido);
		
		for (DetalleFactura detalleFactura : listaDetallesFact) {
			System.out.println(detalleFactura);
		}
		
		this.iFacturaRepository.realizarFactura(miFactura);
		
	}

	@Override
	public Factura buscarPorNumero(Integer numero) {
		return this.iFacturaRepository.buscarPorNumero(numero);
	}

}
