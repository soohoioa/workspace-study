package dao.member;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberDao memberDao=new MemberDao();
		System.out.println("0.delete   --> " + memberDao.deleteByMemberId("bbbb"));
		System.out.println("1.insert   --> " + memberDao.insert(new Member("bbbb", "bbbb", "홍길동", "경기도 포천시", 20, "F", null)));

		Member findMember = memberDao.selectById("aaaa");
		findMember.setM_password("qqqq");
		findMember.setM_name("윤변경");
		findMember.setM_address("충청도 공주시");
		findMember.setM_age(30);
		findMember.setM_married("F");
		
		System.out.println("2.update   --> " + memberDao.updateByMemberId(findMember));
		
		System.out.println("3.selectById-> " + memberDao.selectById("aaaa"));
		System.out.println("4.selectAll--> " + memberDao.selectAll());
		
	}

}
