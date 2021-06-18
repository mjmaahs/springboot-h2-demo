package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "user_id")
	private int userId;	
	@Column(name = "shopping_cart_item_group_id")
	private int shoppingCartItemGroupId;

	public ShoppingCartItem() {
		super();

	}

	public ShoppingCartItem(int userId, BigDecimal price, int quantity, int shoppingCartItemGroupId) {
		this.userId = userId;
		this.price = price;
		this.quantity = quantity;
		this.shoppingCartItemGroupId = shoppingCartItemGroupId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getShoppingCartItemGroupId() {
		return shoppingCartItemGroupId;
	}

	public void setShoppingCartItemGroupId(int shoppingCartItemGroupId) {
		this.shoppingCartItemGroupId = shoppingCartItemGroupId;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [id=" + id + ", userId=" + userId + ", price=" + price + ", quantity=" + quantity
				+ ", shoppingCartItemGroupId=" + shoppingCartItemGroupId + "]";
	}

}
