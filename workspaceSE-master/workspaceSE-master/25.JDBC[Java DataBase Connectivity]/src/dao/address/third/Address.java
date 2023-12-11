package dao.address.third;
/*
 * VO(Value Object)값을 가지는 객체, DTO(Data Transfer Object)데이터 옮기는 객체(계층(Layer)간 데이터를 교환하기 위한 객체)
 * 	- address테이블 1개 row의 데이타의 값을 가지는객체
 *  - address테이블 1개 row의 데이타값을 전달(파라메타,리턴데이타)시키기위한객체
 *  - address테이블의 컬럼과 동일한수의 멤버필드를 가지는객체
 *  
 *  
 * DTO는 순수하게 데이터를 저장하고, 데이터에 대한 getter, setter 만을 가져야한다
 * DTO는 어떠한 비즈니스 로직을 가져서는 안되며, 저장, 검색, 직렬화, 역직렬화 로직만을 가져야 한다
 * 직렬화는 DTO를 Byte, Json, Xml 등의 형태로 변환하는 것을 의미한다. 역직렬화는 그 반대를 의미한다.
 * 데이터 캡슐화를 통해 유연한 대응이 가능하다.
 * 
 * VO 는 변하지 않는 값을 가지는 객체(불변성, immutable), 값이 변하지 않음을 보장하며 코드의 안정성과 생산성을 높인다.
 * VO 는 값이 같다면 동일한 객체이다.
 * 

 이름      널?       유형           
 ------- -------- ------------ 
 NO      NOT NULL NUMBER(4)    
 NAME             VARCHAR2(50) 
 PHONE            VARCHAR2(50) 
 ADDRESS          VARCHAR2(60)
 */
public class Address { // DB 가 있는상태에서 Address 만들기
	
	//데이터베이스 이름과 컬럼 이름을 다르게 줄 필요 없다. 
	private int no;
	private String name;
	private String phone;
	private String address;
	
	public Address() {
		
	}
	
	/* alt+shift+s  -> o  : 생성자 */
	public Address(int no, String name, String phone, String address) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	/* alt+shift+s  -> r  : getter,setter */
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	/* alt+shift+s  -> s  : toString */
	@Override
	public String toString() {
		return "Address [no=" + no + ", name=" + name + ", phone=" + phone + ", address=" + address + "]\n";
	}

	
	
	
}
