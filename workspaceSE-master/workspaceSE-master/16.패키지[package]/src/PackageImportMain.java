import com.itwill.shop.ShopService;
/*
import com.itwill.shop.member.Member;
import com.itwill.shop.member.MemberService;
*/
import com.itwill.shop.member.*;

import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
//import는 클래스 이름 찾아내기위한 로딩

/*
<< The import com.itwill.shop.admin.Product collides with another import statement >>
패키지를 제외한 클래스이름이 동일한클래스는 둘다 import가 불가능하다
import com.itwill.shop.admin.product; 
위에꺼와 이름이 같아서 사용불가 -->> 클래스이름이같은 import들은 클래스 이름을 구분할수있는 방법이 없으므로 사용이불가
단 클래스 이름이 틀리면 찾아주지 않음. 
*/

public class PackageImportMain {

	public static void main(String[] args) {
		/*
		<< 자동 import 단축키 >> 
		ctrl + shift + o
		 */
		
		
		ShopService shopService = new ShopService();
		System.out.println(shopService);
		Member member = new Member();
		System.out.println(member);
		MemberService memberService = new MemberService();
		System.out.println(memberService);
		
		System.out.println("-----com.itwill.shop.product.Product,com.itwill.shop.product.ProductService-----");
		Product shopProduct = new Product();
		System.out.println(shopProduct);
		ProductService productService = new ProductService();
		System.out.println(productService);
		
		
		System.out.println("-----com.itwill.shop.admin.Product,com.itwill.shop.admin.ProductService---------");
		com.itwill.shop.admin.Product adminProduct = new com.itwill.shop.admin.Product();
		System.out.println(adminProduct);
		com.itwill.shop.admin.ProductService adminProductService = new com.itwill.shop.admin.ProductService();
		System.out.println(adminProductService);
		
		
		
	}

}
