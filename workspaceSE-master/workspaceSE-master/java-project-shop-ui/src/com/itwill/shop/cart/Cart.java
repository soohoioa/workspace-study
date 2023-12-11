package com.itwill.shop.cart;

import com.itwill.shop.product.Product;

/*
VO(Value Object),DTO(Data Transfer Object)
	- cart 테이블 1개 row의 데이타의 값을 가지는객체
	- cart 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- cart 테이블의 컬럼과 동일한수의 멤버변수를가지는객체

이름       널?       유형            
-------- -------- ------------- 
CART_NO  NOT NULL NUMBER(10)    
USERID            VARCHAR2(100) 
P_NO              NUMBER(10)    
CART_QTY          NUMBER(10)  	
	
*/
public class Cart {
	private int cart_no;
	private int cart_qty;
	/*********FK*************/
	//private User user;
	private String userId;	
	/*********FK*************/
	//private int p_no;		
	private Product product;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cart_no, int cart_qty, String userId, Product product) {
		super();
		this.cart_no = cart_no;
		this.cart_qty = cart_qty;
		this.userId = userId;
		this.product = product;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", cart_qty=" + cart_qty + ", userId=" + userId + ", product=" + product
				+ "]";
	}
	
	
	
	
	
}