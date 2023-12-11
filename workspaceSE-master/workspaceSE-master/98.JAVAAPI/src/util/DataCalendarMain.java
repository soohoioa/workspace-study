package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataCalendarMain {

	public static void main(String[] args) throws Exception {
		long currentTime = System.currentTimeMillis();
		System.out.println("System.currentTimeMillis() => " + currentTime);
		
		long startTime = System.currentTimeMillis();
		Thread.sleep(12);
		
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("duration : " + duration + " ms");
		
		/*
		 * java.util.Date
		 * 		- The class Date represents a specific instantin time, with millisecond precision. 
		 */
		Date now = new Date(); // 인자없이 데이타 객체 생성시 현재시간 갖고있다.
		String nowString = now.toLocaleString();
		System.out.println(nowString);
		
		long currentTimeMillis1 = now.getTime();
		System.out.println("Date.getTime() => " + currentTimeMillis1);
		
		
		System.out.println("------- SimpleDateFormat[Date -> String] -------"); // 출력할려고 데이터를 스트링으로 변경
		/*
		 * SimpleDateFormat : Date 객체의 시간을 문자열로 변경 해주는 클래스
		 */
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		sdf1.applyPattern("yyyy 년 MM 월 dd 일");
		String formatStr1 = sdf1.format(now);
		System.out.println(formatStr1);
		
		sdf1.applyPattern("yyyy/MM/dd HH:mm:ss:SSSS");
		String formatStr2 = sdf1.format(now);
		System.out.println(formatStr2);
		
		sdf1.applyPattern("yyyy");
		String formatStr3 = sdf1.format(now);
		System.out.println("String -> " + formatStr3);
		System.out.println("int -> " + Integer.parseInt(formatStr3));
		
		
		System.out.println("------- SimpleDateFormat[String -> Date] -------");
		SimpleDateFormat sdf2 = new SimpleDateFormat();
		sdf2.applyPattern("yyyy-MM-dd");
		Date myBirthDay = sdf2.parse("2000-06-30");
		System.out.println(myBirthDay.toString());
		System.out.println(myBirthDay.toLocaleString());
		System.out.println(myBirthDay.getTime());
		
		sdf2.applyPattern("yyyy/MM/dd HH:mm:ss");
		Date yourBirthDay = sdf2.parse("1998/05/12 17:45:23");
		System.out.println(yourBirthDay.toString());
		System.out.println(yourBirthDay.toLocaleString());
		System.out.println(yourBirthDay.getTime());
		
		
		System.out.println();
		System.out.println("-------------- Calendar --------------");
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1);
		long currentTimeMillis2 = cal1.getTimeInMillis();
		System.out.println("Calendar.getTimeInMillis() : " + currentTimeMillis2);
		
		int y = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH); // JANUARY which is 0 때문에 +1 을 해줘야한다.
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		int hour = cal1.get(Calendar.HOUR);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		int msecond = cal1.get(Calendar.MILLISECOND);
		
		System.out.println(y + "/" +  (month +1) + "/" + day + "/" + hour + ":" + minute + ":" + second + "." + msecond);
		
		
		System.out.println("------- Calendar -> Date -------");
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2021, Calendar.JANUARY, 10, 13, 59, 59);
		Date date2 = cal2.getTime();
		System.out.println("Date date2 -> " + date2);
		
		
		
		System.out.println("------- Date 객체 메소드 -------");
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-03");
		Date date4 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-03");
		Date date5 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-15");
		
		System.out.println("date3.equals(date4) : " + date3.equals(date4)); // equals 는 object에 정의된 메소드, 주소비교메소드
		// 여기서는 date3 과 date4의 날짜를 비교한다. 날짜 동일하면 true 반환한다.
		// == 는 주소비교로 사용하지말것. 보통 date는 주소비교가 아닌 날짜를 비교한다.
		System.out.println("date4.equals(date5) : " + date4.equals(date5));
		System.out.println("date3.compareTo(date4) : " + date3.compareTo(date4)); 
		// compareTo 는 String에는 내용비교 앞에서 뒤를 뺀. 같으면 제로가 나옴
		// compareTo 는 Date는 시간을 비교해서 같으면0 반환, 앞쪽이 크면 양수, 앞쪽이 작으면 음수 
		
		System.out.println("date4.compareTo(date5) : " + date4.compareTo(date5)); 
		// date5는 현재 날짜와 가깝기 때문에 크기가 크므로 여기서는 date4가 date5보다 작기때문에 음수를 반환한다.
		System.out.println("date5.compareTo(date4):"+date5.compareTo(date4)); // 양수반환
		
		long getMiliSec = date5.getTime() - date4.getTime(); // 앞에서 뒤를 빼면 차이를 핸들링가능하다.
		System.out.println("getMiliSec : " + getMiliSec); //날짜 차이를 Mil 로 반환
		System.out.println("sec : " + getMiliSec/1000);
		System.out.println("min : " + getMiliSec/1000/60);
		System.out.println("hour : " + getMiliSec/1000/60/60);
		System.out.println("day : " + getMiliSec/1000/60/60/24);
		
		
		System.out.println("------ java.util.Date -> java.sql.Date ------"); //java.util.Date 와 java.sql.Date 는 부모자식관계이다. util 이 부모이고 sql 이 자식
		
		java.util.Date utilDate1 = new java.util.Date();
		java.util.Date utilDate2 = new java.util.Date(System.currentTimeMillis());
		
		java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime()); // 무조건 millis값을 넣어줘야한다. 안그러면 생성 안된다.
		java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
		
		System.out.println(sqlDate1);
		System.out.println(sqlDate2);
		
		System.out.println("------ java.sql.Date -> java.util.Date ------"); // 딱히변경하지 않아도 상위로 캐스팅되서 들어감. 왜냐하면 util이 상위타입이기 때문에
		java.sql.Date sqlDate3 = new java.sql.Date(System.currentTimeMillis());
		java.sql.Date sqlDate4 = new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse("2020/05/05").getTime());
		// new SimpleDateFormat("yyyy/MM/dd").parse("2020/05/05") 까지가 Date 객체이고 Date 객체를 만들고나서 getTime()으로  얻어낼수 있고 sql을 만들수있다.
		System.out.println(sqlDate3);
		System.out.println(sqlDate4);
		
		java.util.Date utilDate3 = sqlDate3;
		java.util.Date utilDate4 = sqlDate4;
		
		System.out.println(utilDate3);
		System.out.println(utilDate4);
		
		//java.util.Date 와 java.sql.Date 는 섞어쓰기도 하므로 변경방법을 잘 알아야함.

	}

}
