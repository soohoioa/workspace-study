
public class AcademyStudent extends AcademyMember{
	/*
	public int no;
	public String name;
	public void print() {
		System.out.print(this.no+"\t"+this.name+"\t");
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
	*/
public String ban; //반
	
	public AcademyStudent() {
		super();
	}
	public AcademyStudent(int no,String name,String ban) {
		super(no, name);
		/*
		 * << The field AcademyMember.name is not visible >>
		this.no = no;
		this.name = name;
		*/
		this.ban = ban;
	}
	// set사용 
	
	/*
	public void print() {
		System.out.print(this.no+"\t"+this.name+"\t");
	}
	*/
	@Override
	public void print() {
		//System.out.println(this.no+"\t"+this.name+"\t"+this.ban);
		super.print();
		System.out.println(this.ban);
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
}
