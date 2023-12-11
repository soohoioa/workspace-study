
public class 예외 {
	
	/* 
	예외: 실행시에발생하는에러
	  0. Throwable : 예외최상위클래스 
		 - The Throwable class is the superclass 
		   of all errors and exceptions in the Java language.
		 - Only objects that are instances of this class (or one of its subclasses) 
		   are thrown by the Java Virtual Machine 
		   or can be thrown by the Java throw statement. 
	  
	  1. Exception : MILD Error(처리대상)
	  2. Error     : Error -> 처리대상아님, 빨리 컴퓨터를 고쳐라..!! 등 
	  
	  
	  * Exception 종류
	   		1. RuntimeException    : throw구문으로 로 자동처리
	   		    ==>프로그래머의 실수로인한 Exception 
	   		    ex> NullPointerException, ArrayIndexOutOfBoundsException
	       
	        2. 비 RuntimeException : 반드시 처리해야한다.
	        	==>프로그램과관계 없이 일어날 가능성이 있는 Exception
	  			ex> network, io, db데이터베이스, file

	  *처리방법 (적극적처리와 소극적처리 가 있다요)
	     ex1> 잡는다.
	     public void method(){
		 	
		     try{ 
		     
		     	익셉션 발생예상코드;
		     	
			 }catch(Exception클래스 e){
			 	익셉션 발생예상코드에서 Exception이발생하면
			 	실행하게될코드;
			 }
		 }
		 
		 ex2> 던진다.
		 
		 	public void method()throws Exception {
		 	
		 		익셉션 발생예상코드;
		 	
		 	}	
		 	
		 예외발생 - 예와발생지점에서 메소드 호출방향이 아닌 반대방향으로 던짐 - 잡는다 - 정상실행되도록 노력 (적극적)
		 예외발생 - 잡는게 아니라 다시 던짐(소극적방법) 

	*/
}
