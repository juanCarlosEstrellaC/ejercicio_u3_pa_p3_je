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
				Item itemOriginal = this.iItemRepository.buscarCodigoBarras(codBarr);
				
				DetalleFactura detalleFact = new DetalleFactura();
				detalleFact.setCantidad(1);
				detalleFact.setMiItem(itemOriginal);
				detalleFact.setPrecioUnitario(itemOriginal.getPrecio());
				
					BigDecimal cant = new BigDecimal(1);
					BigDecimal subtotal = itemOriginal.getPrecio().multiply(cant);
				
				detalleFact.setSubtotal(subtotal);
				detalleFact.setMiFactura(miFactura);

				listaDetallesFact.add(detalleFact);
			}
			
		miFactura.setMiListaDetallesFact(listaDetallesFact);
		
		for (DetalleFactura detalleFactura : listaDetallesFact) {
			System.out.println(detalleFactura);
		}

		
		//this.iFacturaRepository.realizarFactura(listaItemsSensillos, cedula, null);
	}

}
