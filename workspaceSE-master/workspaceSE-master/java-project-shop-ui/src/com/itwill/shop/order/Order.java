package com.itwill.shop.order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 VO(Value Object),DTO(Data Transfer Object)
	- orders 테이블 1개 row의 데이타의 값을 가지는객체
	- orders 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- orders 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
	
주문과 제품 1:n 관계
주문의 입장에서 유저 하나가 여러개주문, 오더는 제품 여러개 포함
오더는 pk가 있어서 반복불가; 여러개 나올수있는건 조인으로만 가능;

오더와 상품은 n:n관계; 자바객체는 컬렉션으로 n:n 관계설정이 가능하지만 
db는 n:n 관계설정이 불가능, 그래서 중간에 관계테이블을 만들어서 1:n관계로 만들어야함;

릴레이션테이블이라고도 불리며 테이블에는 무조건 한개의 pk가 있어야함, 
유일(pk)한 컬럼이 있어야 하므로 복합키 fk2개로 설정을 해야 하지만 이러면 설정시 불편하므로 인공키를 부여한다.

오더에(1)서 오더아이템(N)으로 컬렉션으로 들어와야함, 상품에서 아이템으로 접근불가능, 
오더아이템 꺼내면 제품한개만 나옴, 한개 오더아이템당 한개 프로덕트라 오더아이템에서 보면 1 : 1 관계이지만
프로덕트 입장에서는 오더아이템이 중복가능함;


	이름      널?       유형            
	------- -------- ------------- 
	O_NO    NOT NULL NUMBER(10)    
	O_DESC           VARCHAR2(100) 
	O_DATE           DATE          
	O_PRICE          NUMBER(10)    
	USERID           VARCHAR2(100)  FK
 */
public class Order {

	// 오더아이템이 오더테이블이 참조
	private int o_no; //pk
	private String o_desc;
	private Date o_date;
	private int o_price;
	/************* FK ***************/
	private String userId;
	
	/*
	 * Order 1 : OrderItem N
	 */
	private List<OrderItem> orderItemList;
	
	public Order() {
		// 초기값이 없다면 ArrayList 로 담으면 되지만, 리스트가 객체(값은 없음, 객체로만 존재할뿐)로 있다면 OrderItem 을 담아준다.
		orderItemList = new ArrayList<OrderItem>();
	}

	public Order(int o_no, String o_desc, Date o_date, int o_price, String userId, List<OrderItem> orderItemList) {
		super();
		this.o_no = o_no;
		this.o_desc = o_desc;
		this.o_date = o_date;
		this.o_price = o_price;
		this.userId = userId;
		
		if(orderItemList == null) {
			orderItemList = new ArrayList<OrderItem>();
		} else {	
			this.orderItemList = orderItemList;
		}
		
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public String getO_desc() {
		return o_desc;
	}

	public void setO_desc(String o_desc) {
		this.o_desc = o_desc;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Order [o_no=" + o_no + ", o_desc=" + o_desc + ", o_date=" + o_date + ", o_price=" + o_price
				+ ", userId=" + userId + ", orderItemList=" + orderItemList + "]";
	}
	

	
}
