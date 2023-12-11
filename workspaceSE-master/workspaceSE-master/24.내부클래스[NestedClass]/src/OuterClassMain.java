
public class OuterClassMain {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.outer_member_field = 909090;
		oc.outer_member_method();
		
		
		/*
		이런식으로 사용할 경우는 없음.
		OuterClass.InnerClass ic = oc.new InnerClass(); 
		ic.inner_member_field = 303030;
		ic.innre_member_method();
		*/      //out에 소속된 inner은 이짓을 안함 
		
	}

}
