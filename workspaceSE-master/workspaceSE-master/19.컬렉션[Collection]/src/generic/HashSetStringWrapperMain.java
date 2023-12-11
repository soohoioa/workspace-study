package generic;

import java.util.HashSet;

public class HashSetStringWrapperMain {

	public static void main(String[] args) {
		
		System.out.println("----------String----------");
		HashSet<String> nameSet = new HashSet<String>();
		System.out.println("# set size : " + nameSet.size());
		System.out.println(nameSet);
		System.out.println("----------1. add----------");
		nameSet.add(new String("KIM"));
		nameSet.add("JIM");
		nameSet.add("GIM");
		nameSet.add("SIM");
		System.out.println("# set size : " + nameSet.size());
		System.out.println(nameSet);
		
		boolean isAdd =nameSet.add(new String("KIM"));
		System.out.println("추가여부 : " + isAdd);
		System.out.println("# set size : " + nameSet.size());
		System.out.println(nameSet);
		
		System.out.println("----------Wrapper(Integer)----------");
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		while(lottoSet.size() < 6) {
			isAdd = lottoSet.add(new Integer((int)(Math.random() * 45 +1)));
			// System.out.println(isAdd);
		}
		System.out.println(lottoSet);
		// set은 다른곳에서 다양하게사용한다. - set를 사용하면 중복이 되지않는 데이터를 담는구나 생각하기
		
		
		
		
	}

}
