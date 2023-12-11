import com.itwill.shop.ShopService;

/*
      package 
      1. 관련있는(업무) 클래스의 모음(패키지)
      2. 패키지의 이름은 계층적으로 큰범위부터 작은범위로구성 (도메인형태 뒤집어놓은 형태) 
      3. 클래스의 완전한이름은 패키지를 포함한이름이다.
      4. 이름충돌을 피하기위해서 
      ex> package samson.sds.chongmu;
	     public class Chongmu1{
		 
		 }
       
	  5.compile 방법 
			>javac -d . XXX.java  	
*/
public class PackageMain {

	public static void main(String[] args) {
		// 다시는 이런일이 없는 패키지이름 생략하기
		
		com.itwill.shop.ShopService shopService = new com.itwill.shop.ShopService();
		System.out.println(shopService); 
		// ShopService shopService = new ShopService(); 클래스의 이름은 길다.
		
		com.itwill.shop.member.Member member = new com.itwill.shop.member.Member();
		System.out.println(member);
		
		com.itwill.shop.member.MemberService memberService = new com.itwill.shop.member.MemberService();
		System.out.println(memberService);
		
		
		System.out.println("-----com.itwill.shop.product.Product,com.itwill.shop.product.ProductService-----");
		com.itwill.shop.product.Product shopProduct = new com.itwill.shop.product.Product();
		System.out.println(shopProduct);
		com.itwill.shop.product.ProductService shopProductService = new com.itwill.shop.product.ProductService();
		System.out.println(shopProductService);
		
		System.out.println("-----com.itwill.shop.admin.Product,com.itwill.shop.admin.ProductService---------");
		com.itwill.shop.admin.Product adminProduct = new com.itwill.shop.admin.Product();
		System.out.println(adminProduct);
		com.itwill.shop.admin.ProductService adminProductService = new com.itwill.shop.admin.ProductService();
		System.out.println(adminProductService);
		
		
	}

}
