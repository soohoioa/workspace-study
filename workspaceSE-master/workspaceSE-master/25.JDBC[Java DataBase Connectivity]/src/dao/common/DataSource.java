package dao.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// 공통파일은 공통패키지로 빼는게 좋다
/*
 데이타베이스 설정접속정보룰 이용해서 Connection 을 생성하고(생성해서 반환하고) 
 해지하는 역할을 하는 클래스를 따로 만들겠다 -> 왜냐하면 중복되므로
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
	 데이터베이스 설정정보를 이용해서 Connection 객체를 생성해서 반환하는 역할을 하는 메소드
	 */
	public Connection getConnection() throws Exception {
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	/*
	 Connection 객체를 close 하는 메소드(??)
	 */
	public void close(Connection con) throws Exception {
		con.close(); // 커넥션릴리즈 라고도 씀
	}


	
	
}
