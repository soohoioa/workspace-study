package dao.address;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileLoadMain {

	public static void main(String[] args) throws Exception {
		/*
		 *  .properties 설정파일을 loading 해서 Properties 객체[Map]를 만들어준다.
		 */
		Properties properties = new Properties(); // 웹에서 읽으면 기승전 String
		
		/*
		<< 절대경로 >> 절대로 사용하면 안되는경로 -> 위치는 언제든지 바뀔수있다.
		FileInputStream fis = 
				new FileInputStream("C:\\2023-05-JAVA-DEVELOPER\\workspaceSE\\25.JDBC[Java DataBase Connectivity]\\src\\dao\\address\\PropertiesFileLoadMain.java");
		*/
		/*
		 << 클래스 경로>>
		 */
		InputStream fis = PropertiesFileLoadMain.class.getResourceAsStream("/application.properties");
		
		properties.load(fis);
		System.out.println(properties);
		/*
		  << Properties 객체 >>
		 --------------------------
		 key(String) | value(String)
		 -------------------------
		 username    |  guard
		 password	 |  1111
		 contextPath |  /shopping
		 shop.title  |  울트라짱쇼핑몰
		 */
		
		System.out.println("Properties size : " + properties.size());
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String contextPath = properties.getProperty("contextPath");
		String shopTitle = properties.getProperty("shop.title");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(contextPath);
		System.out.println(shopTitle);
		
		
		
	}

}
