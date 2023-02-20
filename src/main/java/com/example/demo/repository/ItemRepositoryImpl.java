package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ItemRepositoryImpl implements IItemRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresarItem(Item item) {
		this.entityManager.persist(item);
	}

//	//named native
//	@Override
//	public Item buscarCodigoBarras(Integer codigoBarras) {	
//		// SELECT i.item_nombre FROM item i WHERE item_codigo_barras = :datoCodigo
//		Query query = this.entityManager.createNamedQuery("Item.buscarCodigoBarras");
//		query.setParameter("datoCodigo", codigoBarras);
//		return (Item) query.getSingleResult();
//	}

	
	//named native
	@Override
	public Item buscarCodigoBarras(Integer codigoBarras) {
		Query query = this.entityManager.createNamedQuery("Item.buscarCodigoBarras");
		query.setParameter("datoCodigo", codigoBarras);
		return (Item) query.getSingleResult();		
	}

	@Override
	public Long obtenerNumeroItemsBuscadoCodigoBarras(Integer codigoBarras) {	
		// SELECT i.item_nombre FROM item i WHERE item_codigo_barras = :datoCodigo
		Query query = this.entityManager.createNamedQuery("Item.obtenerNumeroItems");
		query.setParameter("datoCodigo", codigoBarras);
		return (Long) query.getSingleResult();
	}
	
	@Override
	public int actualizarPorCodigoBarras(Integer codigoBarras, Integer stock) {  //Retorna un Entero!!
		Query query = this.entityManager.createNamedQuery("Item.actualizarPorCodigoBarras");
		query.setParameter("datoCodigo", codigoBarras);
		query.setParameter("datoStock", stock);
		return query.executeUpdate();
	}

}
