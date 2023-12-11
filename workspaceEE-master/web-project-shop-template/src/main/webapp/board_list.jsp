<%@page import="com.itwill.board.util.PageMaker"%>
<%@page import="com.itwill.board.BoardListPageMakerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.itwill.board.Board"%>
<%@page import="com.itwill.board.BoardService"%>
<%@page import="com.itwill.board.PageInputDto"%>

<%!
public String getTitleString(Board board) {
	
	// StringBuilder를 사용하여 문자열을 효율적으로 조작
	StringBuilder title = new StringBuilder(128);  // 제목을 저장하기 위한 StringBuilder 객체를 생성하며, 초기 용량은 128로 설정한다.
	
	// 게시글의 제목을 가져옴
	String t = board.getTitle(); // 주어진 Board 객체로부터 제목을 가져와 변수 t에 저장한다.
	
	// 제목이 15자를 초과하는 경우, 맨 처음 15자만 표시하고 "..."을 추가
	if (t.length() > 15) { // 제목의 길이가 15자를 초과하는 경우, 처음 15자만 남기고 나머지 부분을 "..."으로 대체
		//t = t.substring(0,15);
		//t = t+"...";
		t = String.format("%s...", t.substring(0, 15));
	}

	//답글공백삽입	
	// 게시글의 들여쓰기를 깊이에 맞게 추가
	for (int i = 0; i < board.getDepth(); i++) { // 게시글의 깊이에 따라 들여쓰기를 추가한다. 들여쓰기의 수는 깊이와 동일하게 설정한다.
		title.append("&nbsp;&nbsp;");
	}
	
	// 게시글의 깊이가 0보다 크면 답글 아이콘을 추가
	if (board.getDepth() > 0) { 
		title.append("<img border='0' src='image/re.gif'/>");
	}
	
	// 제목에 포함된 공백을 HTML에서 인식할 수 있는 형태로 변경
	title.append(t.replace(" ", "&nbsp;"));
		
	// StringBuilder에 저장된 문자열을 String 형태로 변환하여 반환
	return title.toString();
	}
%>

<%
//BoardService boardService = new BoardService();
	//1.요청페이지번호	
// 사용자로부터 전달된 HTTP 요청 파라미터 "pageno"를 가져옵니다. 
// 이는 페이지 번호를 나타냅니다. 만약 "pageno" 파라미터가 없거나 비어있다면, 기본값으로 페이지 번호를 1로 설정합니다.
String pageno=request.getParameter("pageno"); 
if(pageno==null||pageno.equals("")){
	pageno="1";
}	

//게시물조회
/*
BoardService 객체를 이용하여 게시글 목록을 조회하는데, findBoardList 메서드를 호출합니다. 이 메서드는 페이지 번호를 매개변수로 받아 해당 페이지에 보여줄 게시글 목록을 가져오는 역할을 합니다. Integer.parseInt(pageno)를 통해 문자열 형태의 페이지 번호를 정수로 변환하여 메서드에 전달합니다. 이 결과로 BoardListPageMakerDto 객체인 boardListPage가 반환
*/
BoardListPageMakerDto boardListPage 
	=BoardService.getInstance().findBoardList(Integer.parseInt(pageno));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<script type="text/javascript">
	function boardCreate() {
		location.href = "board_write.jsp";
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->

			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>게시판-리스트</b>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="20" class="t1" align="right" valign="bottom">♠
										총 <font color="#FF0000"><%=boardListPage.pageMaker.getTotCount()%></font>
										건 | 현재페이지( <font color="#FF0000"><%=boardListPage.pageMaker.getCurPage()%></font>
										/ <font color="#0000FF"><%=boardListPage.pageMaker.getTotPage()%></font>
										)
									</td>
								</tr>
							</table> <br /> <!-- list -->
							<form name="f" method="post" action="">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">

									<tr>
										<td width=280 align=center bgcolor="E6ECDE">제목</td>
										<td width=120 align=center bgcolor="E6ECDE">글쓴이</td>
										<td width=120 align=center bgcolor="E6ECDE">글쓴날</td>
										<td width=70 align=center bgcolor="E6ECDE">본횟수</td>
									</tr>
									<%
										for (Board board : boardListPage.itemList) {
									%>
									<tr>
										<td width=280 bgcolor="ffffff" style="padding-left: 10px" align="left">
										<a href='board_view.jsp?boardno=<%=board.getBoardNo()%>&pageno=<%=boardListPage.pageMaker.getCurPage()%>'>
										<%=this.getTitleString(board)%>
										</a>
										</td>
										<td width=120 align=center bgcolor="ffffff"><%=board.getWriter()%>
										</td>
										<td width=120 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<%=board.getRegDate().toString().substring(0, 10)%>
										</td>
										<td width=70 align=center bgcolor="ffffff" align="left"><%=board.getReadCount()%>
										</td>
									</tr>
									<!-- 
									<tr>
										<td width=280 bgcolor="ffffff" style="padding-left: 10"><a
											href='board_view.jsp?boardno=532&pageno=6'>게시판타이틀514</a></td>
										<td width=120 align=center bgcolor="ffffff">김경호514</td>
										<td width=120 bgcolor="ffffff" style="padding-left: 10">2014-12-23
										</td>
										<td width=70 align=center bgcolor="ffffff">0</td>
									</tr>
									 -->
									<%
										}
									%>
								</table>
								<!-- /list -->
							</form> <br>
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="center">
							     		 <%if(boardListPage.pageMaker.getCurBlock() > 1) {%>    
											<a href="./board_list.jsp?pageno=<%=boardListPage.pageMaker.getPrevGroupStartPage()%>">◀◀</a>&nbsp;
										 <%}%>
										
										 <%if(boardListPage.pageMaker.getPrevPage()>0) {%>    
											<a href="./board_list.jsp?pageno=<%=boardListPage.pageMaker.getPrevPage()%>">◀</a>&nbsp;&nbsp;
										 <%}%>
										
										<%
											for (int i = boardListPage.pageMaker.getBlockBegin(); i <= boardListPage.pageMaker.getBlockEnd(); i++) {
										 	if (boardListPage.pageMaker.getCurPage() == i) {
										%>
										 <font color='red'><strong><%=i%></strong></font>&nbsp;
										<%} else {%>
										<a href="./board_list.jsp?pageno=<%=i%>"><strong><%=i%></strong></a>&nbsp;
										<%
										   }
										  }%>
										  
										  
										 <%if(boardListPage.pageMaker.getNextPage()<=boardListPage.pageMaker.getTotPage()){%>
										  <a href="./board_list.jsp?pageno=<%=boardListPage.pageMaker.getNextPage()%>">▶</a>
										 <%}%>
										 <%if(boardListPage.pageMaker.getTotBlock() > boardListPage.pageMaker.getCurBlock()){%>
										  <a href="./board_list.jsp?pageno=<%=boardListPage.pageMaker.getNextGroupStartPage()%>">▶▶&nbsp;</a>
										 <%}%>
										
									</td>
								</tr>
							</table> <!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="right"><input type="button" value="게시물 생성"
										onclick="boardCreate();" /></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>