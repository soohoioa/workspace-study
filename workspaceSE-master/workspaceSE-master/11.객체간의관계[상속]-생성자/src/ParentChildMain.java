
public class ParentChildMain {

	public static void main(String[] args) {
		System.out.println("----------Child()----------");
		Child c1 = new Child();
		c1.print();
		
		Child c2 = new Child(100, 200, 300);
		c2.print();
		
	}

}
