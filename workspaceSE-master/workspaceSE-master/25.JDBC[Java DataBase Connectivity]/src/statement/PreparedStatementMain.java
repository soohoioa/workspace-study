package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.sql.Date;

public class PreparedStatementMain {

	public static void main(String[] args) throws Exception {
		
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/

		/********** select sql [Statement] **********
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		
		int sal1 = 1000;
		int sal2 = 4000;
		String job1 = "SALESMAN";
		String job2 = "CLEPK";
		
		String selectSql = "select empno, ename, job, sal, hiredate from emp where sal >= "+sal1+" and sal <= "+sal2+" and job = '"+job1+"' or job = '"+job2+"'";
		
		System.out.println(">> select empno,ename,job,sal,hiredate from emp where sal>=1000 and sal<=4000 and job='SALESMAN' or job='CLERK'");
		ResultSet rs = stmt.executeQuery(selectSql);
		while(rs.next()) {
			System.out.println( rs.getInt("empno") + "\t" + 
								rs.getString("ename") + "\t" +
								rs.getInt("sal") + "\t" + 
								rs.getString("job"));
		}
		
		rs.close();
		
		System.out.println("--------------------------------------------------");
		
		sal1 = 2000;
		sal2 = 5000;
		job1 = "MANAGER";
		job2 = "ANALYST";
		
		selectSql = "select empno, ename, job, sal, hiredate from emp where sal >= "+sal1+" and sal <= "+sal2+" and job = '"+job1+"' or job = '"+job2+"'";
		
		System.out.println(">> select empno,ename,job,sal,hiredate from emp where sal>=2000 and sal<=5000 and job='MANAGER' or job='ANALYST'");
		rs = stmt.executeQuery(selectSql);
		while(rs.next()) {
			System.out.println( rs.getInt("empno") + "\t" + 
								rs.getString("ename") + "\t" +
								rs.getInt("sal") + "\t" + 
								rs.getString("job"));
		}
		rs.close();
		************************************************************/

		
		// 중요!! 여기서 오류 못찾는 경우 많으므로 주의!! 
		// Statement 사용시 처음에 안넣고 실행시 sql을 넣지만 PreparedStatement 는 처음에 sql을 넣고 실행시에는 안넣음
		
		
		/********** [PreparedStatement] **********/
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		
		/****************************** SELECT ******************************/
		System.out.println("-------------- [SELECT] --------------");
		
		//String selectSql="select empno,ename,job,sal,hiredate from emp where sal>=1000 and sal<=4000 and job='SALESMAN' or job='CLERK'";
		String selectSql = "select empno,ename,job,sal,hiredate from emp where sal>= ? and sal<= ? and job=? or job=?";
		PreparedStatement pstmt = con.prepareStatement(selectSql); // 실제로 이 작업은 한번만 하면 된다.

		int sal1 = 1000;
		int sal2 = 4000;
		String job1 = "SALESMAN";
		String job2 = "CLEPK";
		
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println( rs.getInt("empno") + "\t" + 
								rs.getString("ename") + "\t" +
								rs.getInt("sal") + "\t" + 
								rs.getString("job"));
		}
		rs.close(); // rs를 닫으면 널이라는것은 아님
		
		System.out.println("--------------------------------------");
		
		sal1 = 2000;
		sal2 = 5000;
		job1 = "MANAGER";
		job2 = "ANALYST";
		
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println( rs.getInt("empno") + "\t" + 
								rs.getString("ename") + "\t" +
								rs.getInt("sal") + "\t" + 
								rs.getString("job"));
		}
		rs.close();
		pstmt.close();
		
		
		
		System.out.println("-------------- [DELETE] --------------");
		
		// String deleteSql1="delete from emp where empno=9000";
		// SQL문에 동일하다면 값만 변경해서 작업해주면 된다. 속도 빠르고 편함.
		String deleteSql1="delete from emp where empno=?";
		PreparedStatement pstmt0 = con.prepareStatement(deleteSql1);
		pstmt0.setInt(1, 9001);
		int rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9001 번 삭제 : " + rowCount0);
		
		pstmt0.setInt(1, 9002);
		rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9002 번 삭제 : " + rowCount0);
		
		pstmt0.setInt(1, 9003);
		rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9003 번 삭제 : " + rowCount0);
		
		pstmt0.setInt(1, 9004);
		rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9004 번 삭제 : " + rowCount0);
		pstmt0.close();
	
		
		
		System.out.println("-------------- [INSERT] --------------");
		
		/*********************9001 insert ***************************/
		// String insertSql1 = "insert into emp values(9000, 'JUNG', 'MANAGER', 7369, to_date('2000/01/01', 'YYYY/MM/DD'), 3000.34, 30, 40)";
		String insertSql1 = "insert into emp values(?, ?, ?, ?, to_date(?, ?), ?, ?, ?)";
		
		// 변수선언 말고 직접 집어넣기
		// 여기서 pstmt 를 그대로도 사용가능하지만 헷갈릴수있으니 pstmt1을 붙여줫다
		// ? 갯수에 맞춰서 값을 넣어줘야 한다. to_date(?, ?) 같은경우 ? 가 2개 이므로 값을 2개 줘야함.
		PreparedStatement pstmt1 = con.prepareStatement(insertSql1); // PreparedStatement 는 이곳에 인자가 들어가 있다.
		pstmt1.setInt(1, 9001);
		pstmt1.setString(2, "JUNG");
		pstmt1.setString(3, "MANAGER");
		pstmt1.setInt(4, 7369);
		pstmt1.setString(5, "2000/01/01");
		pstmt1.setString(6, "YYYY/MM/DD");
		pstmt1.setDouble(7, 3001.55);
		pstmt1.setInt(8, 30);
		pstmt1.setInt(9, 40);
		
		int rowCount1 = pstmt1.executeUpdate(); // PreparedStatement 는 여기에 인자가 들어가지 않는다.
		System.out.println(">>> PreParedStatement 9001 --> " + rowCount1 + " 행 INSERT");
		
		pstmt1.close();
		
		// ORA-00001: unique constraint (JDEVELOPER03.PK_EMP) violated : insert 를 한번 실행후 한번 더 재 실행하면 에러발생한다.
		// 이미 들어가있는데 한번 더 넣을려고 하니... sql문에 싫어함
		
		
		/*********************9002 insert ***************************/
		// String insertSql2 = "insert into emp values(9002, 'KIM', 'CLEPK', 7369, sysdate, 6000.34, 80, 40)";
		String insertSql2 = "insert into emp values(?, ?, ?, ?, sysdate, ?, ?, ?)";
		PreparedStatement pstmt2 = con.prepareStatement(insertSql2);
		
		pstmt2.setInt(1, 9002);
		pstmt2.setString(2, "KIM");
		pstmt2.setString(3, "CLEPK");
		pstmt2.setInt(4, 7369);
		// pstmt1.setString(5, "2000/01/01");
		// pstmt2.setString(6, "YYYY/MM/DD"); sysdate 는 함수라 자바에서 받지않고 자동으로 들어간다
		pstmt2.setDouble(5, 6000.34);
		pstmt2.setInt(6, 80);
		pstmt2.setInt(7, 40);
		
		int rowCount2 = pstmt2.executeUpdate();
		System.out.println(">>> PreParedStatement 9002 --> " + rowCount2 + " 행 INSERT");

		pstmt2.close();
		
		// ORA-00001: unique constraint (JDEVELOPER03.PK_EMP) violated : insert 를 한번 실행후 한번 더 재 실행하면 에러발생한다.
		// 이미 들어가있는데 한번 더 넣을려고 하니... sql문에 싫어함
		
		
		/*********************9003 insert ***************************/
		// String insertSql3 = "insert into emp values(9003, 'DIM', 'SALESMAN', 7369, 날짜데이터, 8000.99, 70, 40)"; +함수를 사용하지 않겠다.
		String insertSql3 = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt3 = con.prepareStatement(insertSql3);
		
		pstmt3.setInt(1, 9003);
		pstmt3.setString(2, "DIM");
		pstmt3.setString(3, "SALESMAN");
		pstmt3.setInt(4, 7369);
		pstmt3.setDate(5, new Date(System.currentTimeMillis()));
		pstmt3.setDouble(6, 8000.99);
		pstmt3.setInt(7, 70);
		pstmt3.setInt(8, 40);
		
		int rowCount3 = pstmt3.executeUpdate();
		System.out.println(">>> PreParedStatement 9003 --> " + rowCount3 + " 행 INSERT");
		
		pstmt3.close();
		
		/*********************9004 insert ***************************/
		// String insertSql4 = "insert into emp values(9004, null, null, null, null, null, null, null)"; + pk를 제외한 나머지 값이 null일경우
		String insertSql4 = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt4 = con.prepareStatement(insertSql4);
		
		pstmt4.setInt(1, 9004);
		pstmt4.setNull(2, Types.VARCHAR); // 다 널이지만 어떤타입의 널이 들어가는지 적어준다.
		pstmt4.setNull(3, Types.VARCHAR);
		pstmt4.setNull(4, Types.INTEGER);
		pstmt4.setNull(5, Types.DATE);
		pstmt4.setNull(6, Types.DOUBLE);
		pstmt4.setNull(7, Types.INTEGER);
		pstmt4.setNull(8, Types.INTEGER);
		// VARCHAR2 는 오라클에만 존재함.
		int rowCount4 = pstmt4.executeUpdate();
		System.out.println(">>> PreParedStatement 9004 --> " + rowCount4 + " 행 INSERT");
		
		pstmt4.close();
		
		
		
		System.out.println("-------------- [UPDATE] --------------");
		// String updateSql="update emp set sal = sal*1.3 where empno >= 7369 and empno<=7600";
		String updateSql = "update emp set sal = sal* ? where empno >= ? and empno <= ?";	
		PreparedStatement pstmt5 = con.prepareStatement(updateSql);
		pstmt5.setDouble(1, 0.3);
		pstmt5.setInt(2, 7000);
		pstmt5.setInt(3, 8000);
		int rowCount5 = pstmt5.executeUpdate();
		
		System.out.println(">>> PreParedStatement update : " + rowCount5 + " 행 UPDATE");
		
		pstmt5.close();
		con.close();
		
	}

}
