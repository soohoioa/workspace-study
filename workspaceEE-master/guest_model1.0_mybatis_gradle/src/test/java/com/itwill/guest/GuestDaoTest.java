package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuestDaoTest {
	
	
	GuestDao guestDao;
	@BeforeEach // 테스트 메서드 실행 이전에 수행된다.
	void guestDaoCreate() throws Exception{
		guestDao = new GuestDaoImplJDBC();
	}

	@DisplayName("0.Dao객체설정")
	@Test
	void testGuestDao() throws Exception{
		guestDao = new GuestDaoImplJDBC();
		assertNotNull(guestDao); // guestDao 가 not null 이다; assert : 자기 가설을 주장하다.
	}
	
	
	@DisplayName("1.방명록리스트")
	@Test
	void testFindAll() throws Exception{
		List<Guest> guestList = guestDao.findAll();
		assertNotNull(guestList);
		assertNotSame(guestList.size(), 0);
		// System.out.println(guestList);
	}

	@Test
	void testFindByNo() throws Exception{
		Guest guest = guestDao.findByNo(62);
		assertNotNull(guest);
		assertSame(62, guest.getGuest_no());
	}
	
	@Disabled // 테스트 완료시 @Disabled  를 작성하면 이 메소드는 테스트를 안한다. 특히 insert 경우는 매번 해주기 귀찮으므로
	@Test
	void testInsert() throws Exception{
		int insertRowCount = guestDao.insert(
				new Guest(0, "이름", null, "abc@naver.com", "http://www.naver.com", "테스트타이틀", "테스트내용"));
		assertTrue(insertRowCount==1, "삽입실패");
	}

	@Test
	void testUpdate() throws Exception{
		int insertRowCount = guestDao.update(new Guest(0, "이름1", null, "abc@naver.com", "http://www.naver.com", "테스트타이틀", "테스트내용"));
		assertNotNull(insertRowCount);
	}

	@Test
	void testDelete() throws Exception{
		int insertRowCount = guestDao.delete(170);
		assertNotNull(insertRowCount);
	}

}
