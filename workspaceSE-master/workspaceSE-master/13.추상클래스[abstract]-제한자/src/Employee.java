public abstract class Employee {
    private int no; // 번호
    private String name; // 이름
    private int pay; // 급여
    
    public Employee() {
    	
	}
   
    public Employee(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
    
    /*
     * 급여계산
     * 	- 실제 구현 작업 불가능
     * 	- 자식 클래스에서 반드시 재정의 해야하는 메소드 
     * 	- 재정의 강제(규칙, specfication)
     */
	public abstract void calculatePay();
	
	public void print() {
		System.out.print(this.no + "\t" + this.name + "\t" + this.pay + "\t");
	}
	
	
	
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
	
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
