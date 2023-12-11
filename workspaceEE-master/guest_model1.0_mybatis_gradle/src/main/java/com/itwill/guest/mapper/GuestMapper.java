package com.itwill.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.guest.Guest;

public interface GuestMapper { 
	// Mapper 는 단지 세션에서 호출하기 위해 사용하는 인터페이스일뿐이다. (dao 메소드 호출하기위한 Mapper 인터페이스)
	//xml에서 하는 설정은 모두 여기서 할수있따 
	
	
	// @ResultMap("")
	@Select("select * from guest")
	public List<Guest> findAll() throws Exception;
	
	@Select("select * from guest where guest_no=#{guest_no}")
	public Guest findByNo(int guest_no) throws Exception;
	

	/*
	@Insert("insert into guest values(guest_guest_no_seq.nextval,#{guest_name},sysdate,#{guest_email},#{guest_homepage},#{guest_title},#{guest_content})")
	public int insert(Guest guest) throws Exception;
	pk 값으로 반환받고 싶다면 이렇게 작성해라.
	*/
	@SelectKey( statement = "select guest_guest_no_seq.nextval from dual", 
				before = true, 
				keyProperty = "guest_no", 
				resultType = Integer.class)
	@Insert("insert into guest values(#{guest_no},#{guest_name},sysdate,#{guest_email},#{guest_homepage},#{guest_title},#{guest_content})")
	public int insert(Guest guest) throws Exception;
	
	
	@Update("update guest set  guest_name=#{guest_name}, guest_email=#{guest_email}, guest_homepage=#{guest_homepage}, guest_title=#{guest_title}, guest_content=#{guest_content} where guest_no=#{guest_no}")
	public int update(Guest guest) throws Exception;
	
	
	@Delete("delete from guest where guest_no=#{guest_no}")
	public int delete(int guest_no) throws Exception;

	
}


/*
@Select("select * from guest where guest_no= #{guesr_no}")
public Guest findByNo(int no) throws Exception; 이렇게 작성해도 
	#{guesr_no} 와 int no 의 타입이 동일하여 알아서 인식해주지만

@Select("select * from guest where guest_no= #{guesr_no}")
public Guest findByNo(int guesr_no) throws Exception; 이런식으로 
	한개만 있을경우 이름은 동일하게 작성하는게 좋다.

 */








