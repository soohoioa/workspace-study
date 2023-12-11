
public class EmployeePayPrintAbstractMain {

	public static void main(String[] args) {
		Employee[] emps = {
			new SalaryEmployee(1, "고범석", 4000000),	
			new SalaryEmployee(2, "권경록", 4500000),	
			new SalaryEmployee(3, "김숙현", 43000000),	
			new HourlyEmployee(4, "고길동", 220, 10000),
			new HourlyEmployee(5, "김둘리", 100, 9000)
		};
		
		for (Employee employee : emps) {
			employee.calculatePay();
			System.out.println("---------" + employee.getName() + "님 급여명세표---------");
			employee.print();
			System.out.println("-------------------------------------");
		}
	
	}

}
