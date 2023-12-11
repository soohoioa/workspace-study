
public class CarConstructorMain {

	public static void main(String[] args) {
		System.out.println("---------car1----------");
		Car car1 = new Car();
		car1.setIpChaData("1234", 12);
		car1.setOutTime(14);
		car1.calculateFee();
		car1.print();
		
		System.out.println("---------car2----------");
		Car car2 = new Car("8890", 13);
		car2.setOutTime(16);
		car2.calculateFee();
		car2.print();
		
		System.out.println("----- 오늘 주차장 이용 차량 출력 -----");
		Car cara = new Car("1212", 1,2,1000);
		Car carb = new Car("3444", 12, 17, 5000);
		Car carc = new Car("3400", 6, 9, 3000);
		Car card = new Car("9087", 3, 7, 4000 );
		cara.headerPrint();
		cara.print();
		carb.print();
		carc.print();
		card.print();
		
		
	}

}
