
public class ParentChild12Main {

	public static void main(String[] args) {
		System.out.println("-----Child1-----");
		Child1 child1 = new Child1();
		child1.member1 = 1;
		child1.member2 = 2;
		child1.member3 = 3;
		child1.member4 = 4;
		
		
		child1.method1();
		child1.method2();
		child1.method3();
		child1.method4();
		
		System.out.println("-----Child2-----");
		Child2 child2 = new Child2();
		child2.member1 = 1;
		child2.member2 = 2;
		child2.member5 = 5;
		child2.method1();
		child2.method2();
		child2.method5();
		
		/*
		System.out.println("---------Parent----------");
		Parent p=new Parent();
		p.member1=1;
		p.member2=2;
		p.method1();
		p.method2();
		*/
	}

}
