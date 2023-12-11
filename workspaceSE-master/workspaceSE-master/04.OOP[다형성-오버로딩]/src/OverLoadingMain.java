
public class OverLoadingMain {

	public static void main(String[] args) {
		OverLoading overloading = new OverLoading();
		overloading.method();
		overloading.method(123);
		overloading.method("홍길동");
		overloading.method(100, 200);
		overloading.method(100, "이백");
		overloading.method(1, 2, 3);
		overloading.method("일", 2, 3);
		
		
	}

}
