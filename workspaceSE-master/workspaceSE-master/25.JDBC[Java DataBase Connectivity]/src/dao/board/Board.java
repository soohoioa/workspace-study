package dao.board;
/*
VO(Value Object),DTO(Data Transfer Object)
	- board 테이블 1개 row의 데이타의 값을 가지는객체
	- board 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- board 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름               널?       유형             
---------------- -------- -------------- 
BOARD_NO         NOT NULL NUMBER(10)     
BOARD_TITLE               VARCHAR2(255)  
BOARD_CONTENT             VARCHAR2(4000) 
BOARD_WDAY                DATE           
BOARD_READ_COUNT          NUMBER(10)     
 */
public class Board {
	
	private int no;
	private String title;
	private String content;
	private String board_wday;
	private int readCount;
	
	public Board() {
		
	}

	public Board(int no, String title, String content, String board_wday, int readCount) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.board_wday = board_wday;
		this.readCount = readCount;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoard_wday() {
		return board_wday;
	}

	public void setBoard_wday(String board_wday) {
		this.board_wday = board_wday;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", board_wday=" + board_wday
				+ ", readCount=" + readCount + "]\n";
	}
	
	
	
}