package com.itwill99.cls;

public class AbcMain { // 메인블록을 가진 클래스

	public static void main(String[] args) { 
		// Abc 클래스 변수선언
		// Abc st; --> 참조변수 = 클래스변수 = 레퍼런스 변수
		
		// Abc 객체 주소 대입 (객체생성)
		// st = new Abc();
		
		
//		Abc st;
//		st = new Abc();
//		위 아래 같은말로 위에 두줄을 아래 한줄로 표현
//		=>  Abc st = new Abc();
//		여기서 Abc 는 사용자 정의 타입이다
		
		
		
		
		
		/******************************************************/
		// Abc 클래스 변수 선언(주소변수) 
		Abc st; // st의 주소값을 저장할 Abc클래스타입의 참조변수 선언 
		st = new Abc(); // Abc 클래스를 이용해서 st의 객체를 생성한 후 Abc 참조변수에 대입
		// Abc가 틀이고 Abc틀을 가지고 새로운 공간을 만들어낸게 힙에 올라가고 그 힙에 들어갈 객체들을 st라는 참조변수에 대입
		
		
		// Q2. Abc 클래스 변수 선언(주소변수), Abc 객체 3개 생성
		Abc st1 = new Abc();
		Abc st2 = new Abc();
		Abc st3 = new Abc();
		
		
		// Q3. Abc 객체3개의 모든 멤버변수에 값을 대입
		st1.abcf = 1234;
		st1.defdd = 789;
		st1.name = "가나다";
		
		st2.abcf = 234;
		st2.defdd = 234;
		st2.name = "홍길동";
		
		st3.abcf = 34536;
		st3.defdd = 12342;
		st3.name = "라마바";
		
		
		// Q4. 3개 객체 멤버의 내용을 출력
		System.out.println("---------- 출력합시다. ----------");
		System.out.printf("%d %d %s \n", st1.abcf, st1.defdd, st1.name);
		System.out.printf("%d %d %s \n", st2.abcf, st2.defdd, st2.name);
		System.out.printf("%d %d %s \n", st3.abcf, st3.defdd, st3.name);
		
		
		st1.coffee(); // coffee라는 블록(기능의 이름)
		// 호출시 인자를 넣고 반환시 데이터를 가진다
		
		st1.b(34);
		
		
		// Q. 정수인자 1개를 받아서 1 더한수(정수)를 반환하는 메소드 정의
		st1.add(5);
		
		
		st1.c(30);
		System.out.println(st1.c(30));
		
		
		
		
		
		st1.setA("홍길동");
		st1.print();
		
		
		
		
		
	}

}
