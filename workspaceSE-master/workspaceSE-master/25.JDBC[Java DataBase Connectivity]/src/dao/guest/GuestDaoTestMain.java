package dao.guest;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
				
		GuestDao guestDao=new GuestDao();
		
		System.out.println("1.insert");
		System.out.println(">>> row count " + guestDao.insert(new Guest(0, "고소미", null , "ghthal@gmail.com", "http://www.kakao.com", "타이틀", "컨텐트")));
		
		System.out.println("2.delete");
		System.out.println(">>> row count " + guestDao.deleteByGuestNo(3));
		
		System.out.println("3.update");
		Guest findGuest = guestDao.findByGuestNo(5);
		findGuest.setGuestName("김변경");
		findGuest.setGuestEmail("qusrud@gmail.com");
		findGuest.setGuestHomepage("http://www.bobobo.com");
		findGuest.setGuestTitle("변경타이틀");
		findGuest.setGuestContent("변경컨텐트");
		System.out.println(">>> row count " + guestDao.updateByGuestNo(findGuest));
		
		System.out.println("4.findByPrimarykey");
		System.out.println(">>> " + guestDao.findByGuestNo(0));
		
		System.out.println("5.findAll");
		System.out.println(">>> " + guestDao.findByAll());
		
			
	}

}
