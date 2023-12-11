
public class MermaidPrincessMain {

	public static void main(String[] args) {
		System.out.println("---------MermaidPrincess---------");
		//타입은 상위타입대부분 객체는 하위객체, -->> 생성자만큼은 상위타입 으로 생성 불가
		// 그래서 생상자를 주로 봐야함.
		MermaidPrincess mp = new MermaidPrincess();
		mp.Speak();
		mp.think();
		mp.liveSea();
		mp.fastSwim();
		
		System.out.println("---------Mermaid---------");
		Mermaid m = mp;
		/*
		m.Speak();
		m.think();
		*/
		m.liveSea();
		m.fastSwim();
		
		System.out.println("--------Princess---------");
		Princess p = mp;
		p.Speak();
		p.think();
		/*
		p.liveSea();
		p.fastSwim();
		*/
		
		System.out.println("-----Mermaid <--> Princess-----"); // 부모끼리 캐스팅 가능하다(여기서 의미없다)
		Mermaid m2 = new MermaidPrincess();
		m2.fastSwim();
		m2.liveSea();
		Princess p2 = (Princess)m2;
		p2.Speak();
		p2.think();
		
		System.out.println("---------Pbject----------");
		/*
		Object o = new MermaidPrincess();
		o.Speak();
		o.think();
		o.liveSea();
		o.fastSwim();
		*/
		
		
		
		
	}

}
