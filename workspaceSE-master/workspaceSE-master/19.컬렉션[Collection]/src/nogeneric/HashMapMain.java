package nogeneric;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapMain {
 
	public static void main(String[] args) {
		HashMap carMap = new HashMap();
		System.out.println("#map size : " + carMap.size());
		System.out.println(carMap);
		
		System.out.println("--------------- 1. put ---------------");
		Car c1 = new Car("1111", 12);
		carMap.put("1111", c1);		
		carMap.put("2222", new Car("2222", 13));
		carMap.put("3333", new Car("3333", 15));
		carMap.put("4444", new Car("4444", 16));
		carMap.put("5555", new Car("5555", 17));
		
		System.out.println("#map size : " + carMap.size());
		System.out.println(carMap);
		
		
		/*
		 * Key 값은 중복 허용 안한다.
		 */
		// 키값이 중복된다면 중복 된 그 위치에 새로운 객체를 배치함
		carMap.put("3333", new Car("삼삼삼삼", 20));
		System.out.println("#map size : " + carMap.size());
		System.out.println(carMap);
		// equals를 통해 메소드 재정의 
		// 주소비교가 아니라 to String 같은 경우 멤버객체 내용을 비교한다.
		
		System.out.println();
		System.out.println("--------------- 2. get(key) ---------------");
		Object getObjectCar =  carMap.get("3333"); // for문이 필요없음
		Car getCar = (Car)getObjectCar;
		getCar.print();
		
		System.out.println("--------------- 3. remove(key) ---------------");
		Object removeObjectCar = carMap.remove("3333");
		Car removeCar = (Car)removeObjectCar;
		removeCar.print();
		// carMap.remove("3333");
		System.out.println("#map size : " + carMap.size());
		System.out.println(carMap);
		
		System.out.println();
		System.out.println("--------------- 전체 차량 출력 ---------------"); 
		
		Set carEntrySet = carMap.entrySet(); // 이 작업이 하나더 추가됨
		Object[] carObjectEntryArray = carEntrySet.toArray();
//		for (Object carObjectEntry : carObjectEntryArray) {
//			System.out.println(carObjectEntry);
//		}
		for(int i = 0; i < carObjectEntryArray.length; i++) {
			Entry carEntry = (Entry)carObjectEntryArray[i];
			
//			System.out.println("key : " + carEntry.getKey());
//			System.out.println("Value : " + (Car)carEntry.getValue());
			String key = (String)carEntry.getKey();
			Car car = (Car)carEntry.getValue();
			car.print();
		}
		
		System.out.println("--------------------------------------------- ");
		
		for(Object entryObject : carEntrySet) {
			Entry carEntry = (Entry)entryObject;
			String key = (String)carEntry.getKey();
			Car car = (Car)carEntry.getValue();
			car.print();
		}
		

		// Map은 컬렉션의 자식이 아니라서 Set의  Iteration을 사용한다.
		// Set의  Iteration이라 할수있음.
		/**********************전체출력[iteration]**************************/
		System.out.println("*****전체출력[iteration]*****");
		Set carEntrySet2 =  carMap.entrySet();
		//carMap.keySet();
		Iterator carEntryIterator = carEntrySet2.iterator();
		while(carEntryIterator.hasNext()) {
			Entry carEntry = (Entry)carEntryIterator.next();
			String key = (String)carEntry.getKey();
			Car car = (Car)carEntry.getValue();
			System.out.println("Key = " + key);
			car.print();
		}
		
		System.out.println("---------- key ----------");
		Set keySet = carMap.keySet();
		// System.out.println(keySet);
		Iterator keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = (String)keyIterator.next();
			System.out.println("Key = " + key);
			Car car = (Car)carMap.get(key);
			car.print();
		}
		
		
		
		

	}

}
