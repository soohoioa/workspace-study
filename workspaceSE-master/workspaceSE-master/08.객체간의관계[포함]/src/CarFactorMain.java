
public class CarFactorMain {

	public static void main(String[] args) {
		
		/*
		 * 자동차 공장
		 */
		
		/* 캡슐화 전
		Engine porcheEngine = new Engine();
		porcheEngine.type = "A";
		porcheEngine.cc = 5000;
		
		
		Car porcheCar = new Car();
		porcheCar.no = 1234;
		porcheCar.model = "PORCHE";
		porcheCar.engine = porcheEngine;
		
		// porcheCar.print();
		System.out.println(porcheCar.no+"\t"+porcheCar.model+"\t"+
				porcheCar.engine.type+"\t"+porcheCar.engine.cc);
		*/
		
		Engine porcheEngine = new Engine();
		porcheEngine.setType("A");
		porcheEngine.setCc(5000);
		
		Car porcheCar = new Car();
		porcheCar.setNo(1234);
		porcheCar.setModel("PORCHE");
		porcheCar.setEngine(porcheEngine);
		
		porcheCar.print();
		
		System.out.println("----- 차량엔진검사 -----");
		Car gumsaCar = porcheCar;
		Engine returnEngine = gumsaCar.getEngine();
		returnEngine.print();
		
		
		System.out.println();
		Car volvoCar = new Car(5678, "xc90", new Engine("S", 4900));
		volvoCar.print();
		
		System.out.println("----- 차량엔진검사 -----");
		volvoCar.getEngine().print();
		
		
	}

}
