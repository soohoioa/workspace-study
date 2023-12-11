package generic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListStringWrapperMain {

	public static void main(String[] args) {
		 
		System.out.println("---------- String ----------");
		ArrayList <String> nameList = new ArrayList<String>();
		System.out.println("----------1. add ----------");
		nameList.add("KIM");
		nameList.add("JIM");
		nameList.add("HIM");
		nameList.add("SIM");
		nameList.add(new String("TIM"));
		nameList.add("BIM");
		nameList.add("BIM");
		nameList.add("CIM");
		nameList.add("SIM");
		System.out.println(nameList);
		
		System.out.println();
		System.out.println("----------2. get ----------");
		System.out.println(nameList.get(3));
		System.out.println(nameList.get(6));
		
		System.out.println();
		System.out.println("----------3. remove(index) ----------");
		System.out.println(nameList.remove(0));
		System.out.println(nameList);
		
		System.out.println();
		System.out.println("----------3. remove(element) ----------");
		System.out.println(nameList.remove(new String ("TIM")));
		System.out.println(nameList);
		System.out.println(nameList.remove("SIM"));
		System.out.println(nameList);
		
		System.out.println();
		System.out.println("---------- Wrapper ----------");
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		scoreList.add(90);
		scoreList.add(30);
		scoreList.add(45);
		scoreList.add(78);
		scoreList.add(89);
		scoreList.add(new Integer(100));
		System.out.println(scoreList);
		
		System.out.println();
		System.out.println("----------1. get ----------");
		int getScore = scoreList.get(2);
		System.out.println(getScore);
		
		System.out.println(scoreList.get(3));
		
		System.out.println("----------2. set ----------");
		scoreList.set(2, 98);
		System.out.println(scoreList);
		
		System.out.println("----------3. remove ----------");
		scoreList.remove(5);
		System.out.println(scoreList);
		
		// Map은 Wrapper을 하는게 의미없음.
		
		
	}

}
