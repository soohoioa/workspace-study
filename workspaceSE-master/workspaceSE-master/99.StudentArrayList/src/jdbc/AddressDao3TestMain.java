package jdbc;

import java.util.ArrayList;

public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao3 addressDao3 = new AddressDao3();

		System.out.println("1.insert"); 
		int rowCount = addressDao3.insert("이소라", "236-6512", "강원도 홍성시");
		System.out.println(">>> insert rowCount : " + rowCount); // rowCount: 영향반은 행의 수 반환
		
		// 시퀀스(sequence) 를 사용하므로 no는 0 
		Address insertAddress = new Address(0, "신명숙", "235-9685", "충청도 공주시");
		rowCount = addressDao3.insert(insertAddress);
		System.out.println(">>> insert rowCount : " + rowCount);
		
		System.out.println("2.updateByPrimaryKey");
		rowCount = addressDao3.updateByPrimaryKey(4, "수정님", "000-0000", "수정구");
		System.out.println(">>> update rowCount : " + rowCount);
		
		Address updateAddress = new Address(5, "변경님", "111-1111", "변경구");
		rowCount = addressDao3.updateByPrimaryKey(updateAddress);
		System.out.println(">>> update rowCount : " + rowCount);
		
		System.out.println("3.deleteByPrimaryKey");
		addressDao3.deleteByPrimaryKey(39);
		System.out.println(">>> delete rowCount : " + rowCount);
		
		addressDao3.deleteByPrimaryKey(8);
		System.out.println(">>> delete rowCount : " + rowCount);
		
		
		System.out.println("4.findByPrimaryKey");
		Address findAddress1 = addressDao3.findByPrimaryKey(6); 
		Address findAddress2 = addressDao3.findByPrimaryKey(7);
		System.out.println(">>> " + findAddress1);
		System.out.println(">>> " + findAddress2);
		
		System.out.println("5.findAll");
		ArrayList<Address> addressList = addressDao3.findAll();
		System.out.println(">>> " + addressList);
		
		/*
		 메소드의 파라미터 개수는 적을수록 좋다.
		 
		 
		 */
		
		

		
	}

}
