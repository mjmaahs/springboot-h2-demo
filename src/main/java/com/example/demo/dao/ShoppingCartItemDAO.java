package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ShoppingCartItem;

@Repository
public class ShoppingCartItemDAO {

	private EntityManager entityManager;

	@Autowired
	public ShoppingCartItemDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public List<ShoppingCartItem> getShoppingCartByUserId(int theId) {
		Query theQuery = entityManager.createQuery("select e from ShoppingCartItem e where e.userId =: cartUserId");
		theQuery.setParameter("cartUserId", theId);
		List<ShoppingCartItem> cart = (List<ShoppingCartItem>) theQuery.getResultList();
		return cart;
	}

	public List<ShoppingCartItem> findAll() {
		Query theQuery = entityManager.createQuery("from ShoppingCartItem");
		List<ShoppingCartItem> shoppingCartItems = theQuery.getResultList();
		return shoppingCartItems;
	}

	public ShoppingCartItem findById(int theId) {
		ShoppingCartItem theShoppingCartItem = entityManager.find(ShoppingCartItem.class, theId);
		return theShoppingCartItem;
	}

	public void save(ShoppingCartItem theShoppingCartItem) {
		ShoppingCartItem dbShoppingCartItem = entityManager.merge(theShoppingCartItem);
		theShoppingCartItem.setId(dbShoppingCartItem.getId());
	}

	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from ShoppingCartItem where id=:shoppingCartItemId");
		theQuery.setParameter("shoppingCartItemId", theId);
		theQuery.executeUpdate();
	}

}
