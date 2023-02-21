package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Factura;

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
	public void realizarFactura(Factura factura) {
		this.entityManager.persist(factura);
	}

	@Override
	public Factura buscarPorNumero(Integer numero) {
		Query miQuery = this.entityManager.createNamedQuery("Factura.buscarPorNumero");
		miQuery.setParameter("datoFactura", numero);
		return (Factura) miQuery.getSingleResult();
	}

}
