package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao2 addressDao2 = new AddressDao2();

		System.out.println("1.insert");
		addressDao2.insert("이소라", "236-6512", "강원도");

		System.out.println("2.updateByPrimaryKey");
		addressDao2.updateByPrimaryKey(10, "수정님", "000-0000", "수정구");
		addressDao2.updateByPrimaryKey(13, "변경님", "111-1111", "변경구");
		
		System.out.println("3.deleteByPrimaryKey");
		addressDao2.deleteByPrimaryKey(33);
		addressDao2.deleteByPrimaryKey(24);
		
		System.out.println("4.findByPrimaryKey");
		addressDao2.findByPrimaryKey(1); // 갯수는 정해져있지 않고 필요할때마다 호출한다.
		addressDao2.findByPrimaryKey(2);
		addressDao2.findByPrimaryKey(3);
		
		System.out.println("5.findAll");
		addressDao2.findAll();
	}

}
