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
	public void realizarFactura(List<ItemDto> listaItemsSensillos, String cedula, Integer numeroVenta) {
		
//		Factura miFactura = new Factura();
//		miFactura.setCedulaCliente(cedula);
//		miFactura.setFecha(LocalDateTime.now());
//		miFactura.setNumero(numeroVenta);
//				
//		List<DetalleFactura> listaDetallesFact = new ArrayList<>();
//		
//		for (ItemDto itemDto : listaItemsSensillos) {
//			Integer codBarr = itemDto.getCodigoBarras();
//			Item itemOriginal = this.iItemRepository.buscarCodigoBarras(codBarr);
//			
//			DetalleFactura detalleFact = new DetalleFactura();
//			detalleFact.setCantidad(1);
//			detalleFact.setMiItem(itemOriginal);
//			detalleFact.setPrecioUnitario(itemOriginal.getPrecio());
//			
//			BigDecimal cant = new BigDecimal(1);
//			BigDecimal subtotal = itemOriginal.getPrecio().multiply(cant);
//			
//			detalleFact.setSubtotal(subtotal);
//			listaDetallesFact.add(detalleFact);
//			detalleFact.setMiFactura(miFactura);
//
//		}
//		
//		miFactura.setMiListaDetallesFact(listaDetallesFact);
//		
//		for (DetalleFactura detalleFactura : listaDetallesFact) {
//			System.out.println(detalleFactura);
//		}

		
		//this.iFacturaRepository.realizarFactura(listaItemsSensillos, cedula, null);
	}

}
