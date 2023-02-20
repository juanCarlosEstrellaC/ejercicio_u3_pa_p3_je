package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.dto.ItemDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void realizarFactura(List<ItemDto> listaItemsSensillos, String cedula, Integer numeroVenta) {
		Query query = this.entityManager.createNamedQuery("Factura.realizarFactura");
		query.setParameter(0, query);
	}

}
