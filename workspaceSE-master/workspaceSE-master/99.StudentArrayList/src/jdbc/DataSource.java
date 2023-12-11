package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// 공통파일은 공통패키지로 빼는게 좋다
// 계속 이 계정으로 접속해서 작업할꺼라서 공통파일로 빼 두고 작업을 진행한다.

/*
 데이타베이스 설정접속정보룰 이용해서 Connection 을 생성하고(생성해서 반환하고) 
 해지하는 역할을 하는 클래스를 따로 만들겠다 -> 왜냐하면 메소드마다 중복되므로
 (Dao 객체들이 사용하는 클래스)
 */

public class DataSource { // DataSource 객체는 접속정보를 멤버로 갖는다.
	
	/*******데이타베이스 접속정보를 저장할 핃드*******/
	private String driverClass;
	private String url;
	private String user;
	private String password;
	/*************************************************/
	
	public DataSource() throws Exception{
		/******* jdbc.properties 파일을 읽어서 데이터베이스 접속정보를 멤버필드에 저장(초기화작업을 할것이다.)*******/
		Properties properties=new Properties();
		InputStream propertiesInput = DataSource.class.getResourceAsStream("/jdbc.properties");
		properties.load(propertiesInput);
		
		this.driverClass = properties.getProperty("driverClass");
		this.url = properties.getProperty("url");
		this.user = properties.getProperty("user");
		this.password = properties.getProperty("password");
		// 저장위치 변경시 설정파일 변경해주면 된다.
	}
	
	/*
	 Connection 객체를 생성하고 지우는 작업이 많아질수록 속도느려지고 비용도 많이 들어간다. 물론 돈이 많으면 한개씩 작업해서 사용해도 됨ㅋ
	 그래서 Connection 은 예를들어 적은 수(2~3)로 100개의 DAO 와 공유해야한다. -> 적은 수의 Connection 으로 더 많은 메소드를 처리하기 위해서
	 Connection 객체를 미리 생성해서 클래스로 만들고 필요하거나 사용할때마다 주고 다시 받납받는다.
	 */
	
	/* 데이터베이스 설정정보를 이용해서 Connection 객체를 생성해서 반환하는 역할을 하는 메소드 */
	public Connection getConnection() throws Exception {
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	/*  Connection 객체를 close 하는 메소드(??)  */
	public void close(Connection con) throws Exception {
		con.close(); // 커넥션릴리즈 라고도 씀
	}

	/*
	기반 메소드. 반드시 있어야하는 메소드. 
	public Connection getConnection() throws Exception { }
	public void close(Connection con) throws Exception { }
	*/
	
	
}
