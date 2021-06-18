package com.example.demo.helper;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.example.demo.dto.BillDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.ShoppingCartItem;

public class BillHelper {

	private static BillHelper helper = null;

	private BillHelper() {
	}

	public static BillHelper getInstance() {
		if (helper == null)
			return new BillHelper();
		return helper;
	}

	public BillDTO calculateBill(List<ShoppingCartItem> shoppingCartList, Customer customer) {

		// calculate customer period
		int customerPeriod = claculateCustomerPeriod(customer.getCustomerSince());

		// calculate discount percentage if any
		int percentageDiscount = claculateCustomerPercentageDiscount(customer.getCustomerType(), customerPeriod);

		// calculate the over all total, and the total without grocery
		double cartTotal = 0.0d;
		double cartTotalNotGrocery = 0.0d;
		for (ShoppingCartItem item : shoppingCartList) {
			cartTotal += (item.getPrice().doubleValue() * item.getQuantity());
			if (item.getShoppingCartItemGroupId() != Constant.SHOPPING_ITEM_GROUP.GROCERY)
				cartTotalNotGrocery += (item.getPrice().doubleValue() * item.getQuantity());
		}

		double firstDiscount = (percentageDiscount * cartTotal) / 100;
		double secondDiscount = (cartTotalNotGrocery / 100) * 5;

		// return theShoppingCartItem;
		return new BillDTO(cartTotal, firstDiscount, secondDiscount, cartTotal - (firstDiscount + secondDiscount));
	}

	private int claculateCustomerPeriod(Date customerSinceDate) {
		Period period = Period.between(LocalDate.now(),
				customerSinceDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		return Math.abs(period.getDays());
	}

	private int claculateCustomerPercentageDiscount(int customerType, int customerPeriod) {
		int percentageDiscount = 0;
		// get 20% discount if staff
		if (customerType == Constant.EMPLOYEE_SEGMENT.STAFF)
			percentageDiscount = 20;
		// get 15% discount if affiliate
		else if (customerType == Constant.EMPLOYEE_SEGMENT.AFFILIATE)
			percentageDiscount = 15;
		// if customer is since more than 3 years give 10 percent
		else if (customerType == Constant.EMPLOYEE_SEGMENT.REGULAR && customerPeriod > 1095)
			percentageDiscount = 10;

		return percentageDiscount;
	}

}
