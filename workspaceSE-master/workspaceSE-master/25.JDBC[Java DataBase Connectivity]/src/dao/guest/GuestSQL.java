package dao.guest;
/*
 * String 형태의 SQL 을 가지고 있는 클래스
 * 한번에 수정하고 오류 찾기 쉽게하기위해 한곳에 sql을 모아서 작성하고 GuestDao 에 붙여버린다.
 */
public class GuestSQL { 

	public static final String GUEST_INSERT = 
	"insert into guest values(guest_guest_no_seq.nextval, ?, sysdate, ?, ?, ?, ?)";
	// 접근할려면 객체생성 하고 객체생성.aaa 로 들어가야 하지만 굳이 객체생성 할필요없으므로 객체생성 없이 작업할려면 static 사용
	// final 상수. 소문자 사용 안함. 그래서 대문자  GUEST_INSERT 로 작성
	// 내부에서 함수할수 있으면 굳이 외부에서 받을필요없다.
	// sysdate 는 내부함수이므로 굳이 외부에서 받을필요 없어서 그대로 나둠.
	// guest_guest_no_seq.nextval 와 sysdate 는 자동으로 들어가므로 ? 는 5개만 작성
	// guest_guest_no_seq.nextval 사용시 ' ' 는 사용하면 안된다. 왜냐하면 guest_guest_no_seq.nextval 가 알아서 만들어주므로, 문자이면 ' ' 작성해주고 숫자면 그냥 작성 해준다.
	
	
	public static final String GUEST_UPDATE = 
	"update guest set guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
	// UPDATE를 자세하게 작성하고 싶다면 updateByGuestNo 식으로 작성한다. 왜냐하면 업데이트가 많을수도 있으므로 지금은 몇개 없으므로 그냥 업데이트로 작성한다,.
	// ? 는 6개 이고, 데이트 수정이 없다.
	// 대부분 date 는 쓴날짜, 수정날짜 두가지를 모두 가지고 있지만 여기는 없음.
	
	
	public static final String GUEST_DELETE = 
	"delete from guest where guest_no = ?";
	
	
	public static final String GUEST_SELECT_BY_NO = 
	"select * from guest where guest_no = ?";
	
	
	public static final String GUEST_SELECT_ALL = 
	"select * from guest";
	
	// SQL문은 대소문자를 구분하지않는다.
	
	
	
}
