package generic;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain { // set의 가장 큰 특징은 중복을 허용허자 얺는다.
 
	public static void main(String[] args) {
		
		Car car1 = new Car("1111", 1);
		Car car2 = new Car("2222", 2);
		Car car3 = new Car("3333", 3);
		Car car4 = new Car("4444", 4);
		Car car5 = new Car("5555", 5);
		
		HashSet<Car> carSet = new HashSet<Car>();
		System.out.println("# set size : " + carSet.size());
		System.out.println(carSet);
		
		
		System.out.println("---------------1. add ---------------"); // 특정위치추가 없음 add는한가지번전 밖에 없음
		carSet.add(car1);
		carSet.add(car2);
		carSet.add(car3);
		carSet.add(car4);
		carSet.add(car5);
		System.out.println("# set size : " + carSet.size());
		System.out.println(carSet);
		
		
		System.out.println();
		System.out.println("---------------2. add[중복객체] ---------------"); //중복객체 라는것은 주소값이 동일하다 라는것이다.
		/*
		 * Element 의 equals메소드(String은 주소비교안함, char배열 일치여부 확인한다.)를 호출해서 중복을 체크한다. 
		 */
		boolean isAdd = carSet.add(car3); // isAdd가 추가 됫는지 여부 반환
		System.out.println("추가여부 : "+ isAdd);
		System.out.println("# set size : " + carSet.size());
		System.out.println(carSet);
		
		
		System.out.println();
		System.out.println("---------------3. remove(객체) ---------------");
		boolean isRemove = carSet.remove(car1);
		System.out.println("삭제여부 : " + isRemove);
		System.out.println("# set size : " + carSet.size());
		System.out.println(carSet);
		
		
		System.out.println("---------------전체 출력 ---------------");
		System.out.println("--------------- toArray(Object[]) ---------------");
		
		/*
		Object[] carObjectArray = carSet.toArray();
		for (int i = 0; i < carObjectArray.length; i++) { // Array끼리 캐스팅은 불가능하다. Object에 어떤게 들어있을줄 알고..
			Car tempCar =  (Car)carObjectArray[i];
			tempCar.print();
		}
		*/
		System.out.println("--------------- enhance for---------------");
		for (Car car : carSet) {
			car.print();
		}
		
		
		/**********************전체출력[iteration]**************************/
		System.out.println("*****전체출력[iteration]*****");
		Iterator<Car> carIterator = carSet.iterator();
		while (carIterator.hasNext()) {
			Car tempCar = carIterator.next();
			tempCar.print();
		}
		
		
	}

}
