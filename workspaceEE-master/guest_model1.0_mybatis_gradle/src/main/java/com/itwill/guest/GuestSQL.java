package com.itwill.guest;

public class GuestSQL {
	public final static String GUEST_SELECT_ALL
	="select * from guest";
	public final static String GUEST_SELECT_BY_NO
	="select * from guest where guest_no=?";
	public final static String GUEST_UPDATE
	="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
	public final static String GUEST_DELETE
	="delete from guest where guest_no=?";
	public final static String GUEST_INSERT
	="insert into guest values(guest_guest_no_seq.nextval,?,sysdate,?,?,?,?)";
} // 되도록이면 * 보다는 이름으로 작성해주는게 좋다. 왜냐하면 나중에 더 많아질수도 있으므로 차라리 이름으로 작성하는게 좋다.

/*
 xml 로 작성후 매핑하면 * 로 사용이 가능 하지만 인터페이스로 작업시 하나씩 다 써줘야한다.
 select * from guest : 이런식으로 할경우는 xml 로 작업 완료후 가능하고 
 
 "select guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content  from guest"
 이런식으로는 xml 작업안하고 인터페이스로만 작업시에 해야한다.
 
 */

