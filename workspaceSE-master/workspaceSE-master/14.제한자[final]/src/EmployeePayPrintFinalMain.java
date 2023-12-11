
public class EmployeePayPrintFinalMain {
	public static void main(String[] args) {
		Employee[] emps = {	
			new SalaryEmployee(1, "KIM", 45000000),	
			new SalaryEmployee(2, "GIM", 80000000),	
			new SalaryEmployee(3, "VIM", 20000000),	
			new HourlyEmployee(4, "HOM", 100, 30000),
			new HourlyEmployee(5, "GON", 100, 10000)
		};
		
		for (Employee emp : emps) {
			emp.calculatePay();
			System.out.println("------------" + emp.getName() + "님 급여명세표 ----------");
			emp.print();
			double incentive = emp.calulateIncentive();
			// 여기서 calulateIncentive(); 는 상속에의해서만 사용됨
			System.out.println("\t인센티브 : " + incentive);
			System.out.println("---------------------------------------");
		}
		
		System.out.println("사원 인센티브율 : " + Employee.INCENTIVE_RATE);
	}
	
}
