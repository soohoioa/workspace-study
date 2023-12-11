package resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import dao.common.DataSource;

public class ResultsetMain {
	
	/*
	<< product >>
	이름         널?       유형            
	---------- -------- ------------- 
	NO         NOT NULL NUMBER(7)     
	NAME                VARCHAR2(50)  
	SHORT_DESC          VARCHAR2(255) 
	PRICE               NUMBER(10,3)  
	IPGO_DATE           DATE          

	 */
	
	public static void main(String[] args) throws Exception {
		String selectSql = "select no,name,short_desc,price,ipgo_date from product";
		Connection con = new DataSource().getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		
		
		System.out.println("----- ResultSet.get타입(컬럼이름) -----");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String shortDesc = rs.getString("short_desc");
			double price = rs.getDouble("price");
			Date ipgoDate = rs.getDate("ipgo_date");
			// String ipgoDateStr = new SimpleDateFormat("yyyy년 MM월 dd일").format(ipgoDate);
			// System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDateStr);
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close(); // rs == null 을 하지 않는이상 닫는다고 해서 널은 아니다.
		
		
		System.out.println("----- ResultSet.get타입(컬럼index) -----");
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2);
			String shortDesc = rs.getString(3);
			double price = rs.getDouble(4);
			Date ipgoDate = rs.getDate(5);
			// select 로 뽑은 다음에 rs로 캐치한다. 만약 no, name 이 name, no 로 바뀐다면 name 은 1, no 는 2가됨
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close(); // index로도 사용하지만 보통은 컬럼명을 이용해서 뽑는다.
		
		
		System.out.println("----- ResultSet.getString(컬럼이름) -----"); // 모두 String 로 반환한다.
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String no = rs.getString("no");
			String name = rs.getString("name");
			String shortDesc = rs.getString("short_desc");
			String price = rs.getString("price");
			String ipgoDate = rs.getString("ipgo_date");
			
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();

		
		System.out.println("----- ResultSet.getObject(컬럼이름) -----"); 
		rs = pstmt.executeQuery();
		while(rs.next()) {
			Object no = rs.getObject("no"); // Object 를 사용하면 Object 가 알아서 판단해서 값을 출력해준다.
			Object name = rs.getObject("name");
			Object shortDesc = rs.getObject("short_desc");
			Object price = rs.getObject("price");
			Object ipgoDate = rs.getObject("ipgo_date");
			
			System.out.println(no + "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();	// 보통 Object 는 잘 사용하지 않고 맞는 타입을 기술해줘야한다.

	}

}
