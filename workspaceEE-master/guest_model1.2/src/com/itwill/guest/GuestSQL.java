package com.itwill.guest;

public class GuestSQL {
	public final static String GUEST_SELECT_ALL
	="select * from guest order by guest_no desc";
	public final static String GUEST_SELECT_BY_NO
	="select * from guest where guest_no=?";
	public final static String GUEST_UPDATE
	="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
	public final static String GUEST_DELETE
	="delete from guest where guest_no=?";
	public final static String GUEST_INSERT
	="insert into guest values(guest_guest_no_seq.nextval,?,sysdate,?,?,?,?)";
}
