package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.ShoppingCartItemDAO;
import com.example.demo.dto.BillDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.ShoppingCartItem;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ShoppingCartItemService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ShoppingCartItemService shoppingCartItemService;

	@MockBean
	private CustomerDAO customerDAO;
	@MockBean
	private ShoppingCartItemDAO shoppingCartItemServiceDAO;

	@Test
	public void findAllTest() {
		
		// Mocking Date
		when(customerDAO.findAll()).thenReturn(
				Stream.of(new Customer("steve.rogers", 1, new Date()), new Customer("peter.parker", 2, new Date()))
						.collect(Collectors.toList()));
		
		// Test case and confirming it
		assertEquals(2, customerService.findAll().size());
	}

	@Test
	public void discountLessThen25Percent() {

		// Mocking Date
		when(customerDAO.findById(1)).thenReturn(new Customer("steve.rogers", 1, new Date()));
		when(shoppingCartItemServiceDAO.getShoppingCartByUserId(1))
				.thenReturn(Stream.of(new ShoppingCartItem(1, new BigDecimal("50"), 2, 1),
						new ShoppingCartItem(1, new BigDecimal("400"), 2, 1)).collect(Collectors.toList()));

		// Test case
		BillDTO billTest = shoppingCartItemService.addShoppingCartItem(
				new ShoppingCartItem(1, new BigDecimal("400"), 2, 1), new Customer("steve.rogers", 1, new Date()));

		// Confirm the test case
		double priceBeforeDiscount = billTest.getTotalBeforeDiscount();
		double priceAfterDiscount = billTest.getTotalAfterDiscount();
		assertThat((priceBeforeDiscount / 4) >= (priceBeforeDiscount - priceAfterDiscount));
	}

}
