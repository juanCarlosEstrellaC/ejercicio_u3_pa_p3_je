package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	
	//named native
	@Override
	public Item buscarCodigoBarras(Integer codigoBarras) {
		Query query = this.entityManager.createNamedQuery("Item.buscarCodigoBarras");
		query.setParameter("datoCodigo", codigoBarras);
		return (Item) query.getSingleResult();		
	}
	
	//con criteria
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


	@Override
	public Integer obtenerNumeroStock(Integer codigoBarras) {
		// Buscaré el objeto completo usando Criteria, y luego obtengo el número de stock de dicho objeto y lo retorno.
		
		// 1. Creo la fábrica:
		CriteriaBuilder miFabrica = this.entityManager.getCriteriaBuilder();
		
		// 2. Declaro tipo de retorno del SQL
		CriteriaQuery<Item> criteriaQuery = miFabrica.createQuery(Item.class);  // El SQL me retornará un Item
		
		// 3. Crear el SQL
		//	 3.1. From
		Root<Item> miTablaItem = criteriaQuery.from(Item.class);						 	            // FROM item i
		
		// 	 3.2. Where (predicados de Criteria)
		Predicate predicate1 = miFabrica.equal(miTablaItem.get("codigoBarras"), codigoBarras); 	        // WHERE i.codigoBarras = codigoBarras
																									    // El primer "codigoBarras" viene del nombre del atributo de la Clase
		// 4. Declarar el Query
		criteriaQuery.select(miTablaItem).where(predicate1);
		
		// 5. Ejecuto mi Query con TypedQuery:
		TypedQuery<Item> typedQuery = this.entityManager.createQuery(criteriaQuery);  //sin el parámetro de Item.class, porque en el paso 2 especifico el tipo de dato de retorno.
		
		// Atrapo el resultado en una variable y retorno su stock:
		Item itemEncotradoCriteria = typedQuery.getSingleResult();
		return itemEncotradoCriteria.getStock();
	}

}
