package lang;

public class ObjectChild extends Object{
	
	@Override 
	public boolean equals(Object obj) {
		
		return !super.equals(obj);
	}
	
	@Override
	public String toString() {
		
		return "난 Object 자식 객체다!";
	}
	
	
	
	
}
