package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.ShoppingCartItem;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ShoppingCartItemService;

@RestController
public class HomeRestController {

	private CustomerService customerService;
	private ShoppingCartItemService shoppingCartItemService;

	@Autowired
	public HomeRestController(CustomerService theCustomerService, ShoppingCartItemService theShoppingCartItemService) {
		customerService = theCustomerService;
		shoppingCartItemService = theShoppingCartItemService;
	}

	@PostMapping("/shoppingCartItems")
	public BillDTO addShoppingCartItem(@RequestBody ShoppingCartItem theShoppingCartItem) {
		return shoppingCartItemService.addShoppingCartItem(theShoppingCartItem,
				customerService.findById(theShoppingCartItem.getUserId()));
	}
	
	@GetMapping("/customers")
	public List<Customer> findAllCustomers() {
		return customerService.findAll();
	}

}
