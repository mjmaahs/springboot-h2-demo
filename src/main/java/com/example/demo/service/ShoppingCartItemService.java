package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ShoppingCartItemDAO;
import com.example.demo.dto.BillDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.ShoppingCartItem;
import com.example.demo.helper.BillHelper;

@Service
public class ShoppingCartItemService {

	private ShoppingCartItemDAO shoppingCartItemDAO;

	@Autowired
	public ShoppingCartItemService(@Qualifier("shoppingCartItemDAO") ShoppingCartItemDAO theShoppingCartItemDAO) {
		shoppingCartItemDAO = theShoppingCartItemDAO;
	}

	@Transactional
	public BillDTO addShoppingCartItem(ShoppingCartItem theShoppingCartItem, Customer customer) {

		// save shopping item to DB
		theShoppingCartItem.setId(0);
		shoppingCartItemDAO.save(theShoppingCartItem);

		// get cart and customer from DB
		List<ShoppingCartItem> shoppingCartList = shoppingCartItemDAO
				.getShoppingCartByUserId(theShoppingCartItem.getUserId());

		return BillHelper.getInstance().calculateBill(shoppingCartList, customer);
	}

}
