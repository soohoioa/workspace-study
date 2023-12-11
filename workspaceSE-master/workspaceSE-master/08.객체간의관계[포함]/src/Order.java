
public class Order {
	private int no; 		// 주문번호
	private String title; 	// 주문이름
	private String date;	// 주문일자
	private int price;		// 주문가격
	// 필드 생성자 메소드
	
	public Order() {
		
	}

	public Order(int no, String title, String date, int price) {
		this.no = no;
		this.title = title;
		this.date = date;
		this.price = price;
	}
	

	public void print() {
		System.out.println("Order [no=" + no + ", title=" + title + ", date=" + date + ", price=" + price + "]");
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Order [no=" + no + ", title=" + title + ", date=" + date + ", price=" + price + "]"; // 여기서 this는 생략되어있다
	}

	
	
}
