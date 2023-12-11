package com.itwill.guest;

import java.util.List;

public class GuestService { // GuestService 작업시 계속 변경하면 다 바꿔야하므로 차라리 상위 클래스를 만들어서 상속받게해라 
	
	private GuestDao guestDao; // 상위 클래스를 만들면 클래스는 건들필요없고 생성자만 건들이면 된다. 하지만 생성자는 왔다갔다 해야하는 불편함은 조금 남아있다.
	public GuestService() throws Exception{
		//guestDao=new GuestDaoImplJDBC();
		guestDao=new GuestDaoImplMyBatis();
		
	}
	/*
	 * 방명록 리스트
	 */
	public List<Guest> findAll()throws Exception{
		return guestDao.findAll();
	}
	public int insert(Guest guest) throws Exception{
		return guestDao.insert(guest);
	}
	public Guest findByNo(int guest_no) throws Exception{
		return guestDao.findByNo(guest_no);
	}
	public int delete(int guest_no) throws Exception{
		return guestDao.delete(guest_no);
	}
	public int update(Guest guest) throws Exception{
		return guestDao.update(guest);
	}
}