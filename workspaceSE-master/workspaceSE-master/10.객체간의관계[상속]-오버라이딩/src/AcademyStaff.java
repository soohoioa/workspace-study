
public class AcademyStaff extends AcademyMember{

public String depart; //부서
	
	public AcademyStaff(int no,String name,String depart) {
		this.no = no;
		this.name = name;
		this.depart = depart;
	}
	public void Print() {
		super.print();
		System.out.println(this.depart);
	}
	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	
}
