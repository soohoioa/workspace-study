package com.itwill.shop.order;
/*
  VO(Value Object),DTO(Data Transfer Object)
	- orders 테이블 1개 row의 데이타의 값을 가지는객체
	- orders 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- orders 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
 
 이름     널?       유형         
------ -------- ---------- 
OI_NO  NOT NULL NUMBER(10) 
OI_QTY          NUMBER(10) 
O_NO            NUMBER(10) 
P_NO            NUMBER(10) 
 */

import com.itwill.shop.product.Product;

public class OrderItem {
	
	private int oi_no;
	private int oi_qty;
	
	/************* FK ***************/
	private int o_no;
	
	/************* FK ***************/
	//private int p_no;
	private Product product; 
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int oi_no, int oi_qty, int o_no, Product product) {
		super();
		this.oi_no = oi_no;
		this.oi_qty = oi_qty;
		this.o_no = o_no;
		this.product = product;
	}

	public int getOi_no() {
		return oi_no;
	}

	public void setOi_no(int oi_no) {
		this.oi_no = oi_no;
	}

	public int getOi_qty() {
		return oi_qty;
	}

	public void setOi_qty(int oi_qty) {
		this.oi_qty = oi_qty;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [oi_no=" + oi_no + ", oi_qty=" + oi_qty + ", o_no=" + o_no + ", product=" + product + "]";
	}
	

	
}
