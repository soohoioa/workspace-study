package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 DAO (Data Access Object) 클래스 : 데이터베이스클래스
 	- address 테이블에 CRUD (Create, Read, Update, Delete) 작업을 하는 단위 메소드를 가지고 있는 클래스
 */

/*
 AddressDao 클래스 작성 순서 ++ 

0. 테이블설계(create drop) 					-->address_table_create_drop.sql 파일생성

1. sql문작성(insert,update,delete,select)	-->addresss_insert_update_delete_select.sql 파일생성

2. Dto(VO)클래스작성 + 타입기술,인자받음

3. Dao클래스작성
 	- 테이블에 insert,delete,update,findByPk(반환 : dto),selectAll(dto컬렉션, dto리스트) 단위메쏘드만들기
    - 단위메쏘드(인자 반환타입정의)생성
    
4.<<< 반드시 테스트 되어야합니다.>>> 왜냐하면 여러개의 클래스를 사용할꺼라서 반드시 테스트 해보고 다음을 진행한다.
	public class AddressDaoTestMain{
		public static void main(String[] args){
		  AdderessDao adderssDao=new AdderessDao();
		  adderssDao.insert();
		} 
	}   
	
5. 테스트가 완료되면 다음 작업으로 넘어간다.	
 
 
 */

/*
 DAO DTO VO
 
 VO(Value Object)값을 가지는 객체, DTO(Data Transfer Object)데이터 옮기는 객체(계층(Layer)간 데이터를 교환하기 위한 객체)
 - address테이블 1개 row의 데이타의 값을 가지는객체
 - address테이블 1개 row의 데이타값을 전달(파라메타,리턴데이타)시키기위한객체
 - address테이블의 컬럼과 동일한수의 멤버필드를 가지는객체
  
  
DTO는 순수하게 데이터를 저장하고, 데이터에 대한 getter, setter 만을 가져야한다
DTO는 어떠한 비즈니스 로직을 가져서는 안되며, 저장, 검색, 직렬화, 역직렬화 로직만을 가져야 한다
직렬화는 DTO를 Byte, Json, Xml 등의 형태로 변환하는 것을 의미한다. 역직렬화는 그 반대를 의미한다.
데이터 캡슐화를 통해 유연한 대응이 가능하다.
VO 는 변하지 않는 값을 가지는 객체(불변성, immutable), 값이 변하지 않음을 보장하며 코드의 안정성과 생산성을 높인다.
VO 는 값이 같다면 동일한 객체이다.
 */

/*****************************************************************************************************************************************************/
public class AddressDao3 {
	
	/* 데이터베이스 설정정보를 이용해서 Connection 객체를 생성해서 반환하는 역할을 하는 메소드 */
	public Connection getConnection() throws Exception {
		/*******데이타베이스 접속정보[182.237.126.19]************/ 	
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	/*
	 Connection 객체를 생성하고 지우는 작업이 많아질수록 속도느려지고 비용도 많이 들어간다. 물론 돈이 많으면 한개씩 작업해서 사용해도 됨ㅋ
	 그래서 Connection 은 예를들어 적은 수(2~3)로 100개의 DAO 와 공유해야한다. -> 적은 수의 Connection 으로 더 많은 메소드를 처리하기 위해서
	 Connection 객체를 미리 생성해서 클래스로 만들고 필요하거나 사용할때마다 주고 다시 받납받는다.
	 */

	/*  Connection 객체를 close 하는 메소드(??)  */
	public void close(Connection con) throws Exception {
		con.close(); // 커넥션릴리즈 라고도 씀
	}
	/*
	기반 메소드. 반드시 있어야하는 메소드. 
	public Connection getConnection() throws Exception { }
	public void close(Connection con) throws Exception { }
	*/
	
	// 공통으로 들어가서 멤버로 빼주었고, 계속 이 계정으로 접속해서 작업할꺼라서 공통파일로 빼 두고 작업을 진행한다.
	// DataSource 클래스로 새로 만들어 주었고 여기서는 멤버로 빼준상태에서 작업진행한다.
	
	/*****************************************************************************************************************************************************/
	
	public int insert(String name, String phone, String address) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval, '"+name+"', '"+phone+"', '"+address+"')";
				// 시퀀스(sequence)는 순서에 따라 나열되는 정수의 목록이라고 정의할 수 있다. 또 유일한 값을 생성해주는 오라클의 객체다. 줄수도 안줄수도있다
				// nextval :자기가 알아서 증가시키겠다. 여기서는 address 클래스 내 no 를 순차적으로 증가시키겠다.
		Connection con = this.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		
		// System.out.println(" >> insert row count : " + rowCount);	
		
		stmt.close();
		this.close(con);
		return rowCount;
	}
	// 여기는 ' ' 와 " " 와 + + 가 같이 사용하는 굉장히 복잡한 코드라서 예제일뿐, 실제로는 이렇게 작성 안함
	
	/*****************************************************************************************************************************************************/
	
	public int insert(Address insertAddress) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval, ?, ?, ?)"; // ? 를 넣을때는 ' ? ' 이렇게 넣으면 에러 발생이므로 그냥 ? 만 사용한다
		/*  중요!! 여기서 오류 못찾는 경우 많으므로 주의!! 
			Statement 사용시 처음에 안넣고 실행시 sql을 넣지만 PreparedStatement 는 처음에 sql을 넣고 실행시에는 안넣음
			
				Statment 사용시
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				int rowCount = stmt.executeUpdate(updateSql); -> 이곳에 sql 이 들어가있다.
			
				PreparedStatement 사용시
				Connection con = this.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(insertSql); -> 이곳에 sql 이 들어가있다.
				int rowCount = pstmt.executeUpdate();
			 여기 주의해서 작성하기
		*/
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1, insertAddress.getName());
		pstmt.setString(2, insertAddress.getPhone());
		pstmt.setString(3, insertAddress.getAddress());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		this.close(con);
		
		return rowCount;
	}
	
	/*****************************************************************************************************************************************************/
	
	public int updateByPrimaryKey(int no, String name, String phone, String address) throws Exception { // 기본적으로 pkUpdate pkDalete
		String updateSql = "update address set name = ? , phone = ? , address = ? where no = ? ";
		// 업데이트는 모든 컬럼이 다 필요하지만 물론 수정이 불가능한 컬럼도 있음. 하지만 대부분 전체 다 수정함. 부분수정은 매우 드물다.
		// 외워랍! 업데이트는 pk조건으로 모든 필드를 업데이트 왜? 어떤걸 업데이트할지 모르니까.
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		pstmt.setInt(4, no);
		int rowCount = pstmt.executeUpdate();
		
		// System.out.println(" >> update row count : " + rowCount);	
		
		pstmt.close();
		this.close(con);
		return rowCount;
	}
	
	/*****************************************************************************************************************************************************/
	
	public int updateByPrimaryKey(Address updateAddress) throws Exception {
		String updateSql = "update address set name = ? , phone = ? , address = ? where no = ? ";
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, updateAddress.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());
		// no 가 마지막에 있으므로 pstmt 작성시 주의필요
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		this.close(con);
		return rowCount;
	}
	
	/*****************************************************************************************************************************************************/
	
	public int deleteByPrimaryKey(int no) throws Exception {
		String deleteSql = "delete from address where no = ?";
		
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		
		//System.out.println(" >> delete row count : " + rowCount);

		pstmt.close();
		this.close(con);
		return rowCount;
	}
	
	/*****************************************************************************************************************************************************/
	
	public Address findByPrimaryKey(int no) throws Exception { // selectByNo 도 no 가 pk 라면 가능.
		Address findAddress = null;
		
		String selectSql = "select no, name, phone, address from address where no = ?";
		
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();		

		if(rs.next()) {
				int number = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				// System.out.println(number +" "+ name +" "+ phone +" "+ address); 출력이 아닌 값을 반환해라. 반환을 할꺼라서 출력문은 주석처리 해줌
				findAddress = new Address(number, name, phone, address);
		}
		rs.close();
		pstmt.close();
		this.close(con);
		return findAddress; // 객체가 만들어지던지 아니면 널이던지 둘중 하나
	}
	
	/*****************************************************************************************************************************************************/
	
	//  ArrayList<Address> dto리스트라고도 함
	public ArrayList<Address> findAll() throws Exception { // selectByPrimaryKey 라고도 작성하지만 대부분 find 를 붙여서 사용함
		// findAll() 은 파라메타가 없어서 안해도 됨. findAll() 주로 검색할때 사용
		ArrayList<Address> addressList = new ArrayList<Address>();
		
		String selectSql = "select no, name, phone, address from address order by no";
		
		Connection con = this.getConnection();
		Statement stmt = con.createStatement();				
		ResultSet rs = stmt.executeQuery(selectSql);		

		if(rs.next()) {
			do{
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				Address tempAddress = new Address(no, name, phone, address); 
				addressList.add(tempAddress);
				// System.out.println(no+" "+name+" "+phone+" "+address);
			}while(rs.next());
		}
		rs.close();
		stmt.close();
		this.close(con);
		return addressList;
	}
	
	/*****************************************************************************************************************************************************/



	
	/*
	close 작업시 먼저 시작한 객체가 제일 마지막에 닫혀야한다. 여기서는 con 이 먼저 시작하고 rs가 마지막에 실행되었으므로
	rs가 먼저 닫히고 마지막으로 con 을 닫아준다
	
	단위메소드로 조합한다 - 실제 업무 구현
	하나하나 분리해서 내가 원하는형체로 만든다 -> 하나의 메소드가 하나의 일만 해야한다
	
	dml문은 영향받은 행의수를 insert 로 반환 , select 문을 제외 
	
	데이터베이스 모델링 -> dao작성
	
	
	*/
	
	
	
	
	
}
