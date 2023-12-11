package com.itwill.shop.product;
/*
 -- 제품리스트
select * from product;
-- 제품 상세보기
select * from product where p_no=1;

 */
public class ProductSQL {
	public final static String PRODUCT_SELECT_ALL="select * from product";
	public final static String PRODUCT_SELECT_BY_NO="select * from product where p_no=?";
	
	
}
