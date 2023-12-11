public abstract class Employee {
    private int no; // 번호
    private String name; // 이름
    private int pay; // 급여
    
    public final static double INCENTIVE_RATE = 0.1; // 여기서 숫자만 바꾸어주면 됨
   
    
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
	/*
	 * 인센티브 계산 메소드 추가(급여가 200만원이 넘으면 10% 인센티브 지급)
	 * 		- 모든 사원들의 인센티브 계산방법이 동일
	 * 		- 재정의 금지(회장님의 방침, 변경금지)
	 */
	public final double calulateIncentive() { // final 상속받아서 모든 인센티브 계산이 동일
		double incentive = 0.0;
		if(this.pay > 2000000) {
			incentive = this.pay * Employee.INCENTIVE_RATE; // 앞에 class(Employee). 생략 가능 , this.pay * INCENTIVE_RATE;도 가능하다 
		}
		return incentive;
	}
	
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
