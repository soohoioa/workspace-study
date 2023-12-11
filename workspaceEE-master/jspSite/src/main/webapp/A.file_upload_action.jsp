<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("A.file_upload_form.jsp");
		return;
	}
	/*
	file upload component사용
	public MultipartRequest(javax.servlet.http.HttpServletRequest request,
            java.lang.String saveDirectory,
            int maxPostSize,
            java.lang.String encoding)
     throws java.io.IOException
	*/
	
	String saveDirectory=application.getRealPath("/upload");// 경로지정인데 되도록이면 상대경로로 해라
	// application.getRealPath(""); 는 webapp 까지의 경로이다.
	// (""); 안에 경로를 넣으면 잡아서 반환
	int maxPostSize = 1024*1024*100; //업로드 최대 사이즈 지정
	String encoding="UTF-8";
	
	/*
	- DefaultFileRenamePolicy : 똑같은 이름을가진파일이 존재한다면 파일명(숫자) 1,2,3..를 붙여서 저장해주는 클래스
	- FileRenamePolicy        : 똑같은 이름을가진파일이 존재한다면 사용자가 만든이름을 적용시킬수있게해주는 클래스
	*/
	DefaultFileRenamePolicy fileRenamePolicy=new DefaultFileRenamePolicy();
	
	MultipartRequest multipartRequest=
			new MultipartRequest(request,saveDirectory,maxPostSize,encoding,fileRenamePolicy);
	
	// 객체생성하면 업로드가 끝난다. 생성시 첫번째는 request , 두번째는 어디에 저장할꺼냐 경로지정 saveDirectory
	// 세번째는 최대사이즈(무한으로 하면 서버 뻗을수있으므로 적당히 줘야한다.) maxPostSize
	// 네번째는 인코딩, 안해주면 한글깨짐 encoding
%>
<h1>Upload Data</h1>
<hr/>
<ul>
<li>application.getRealPath(""): <%=application.getRealPath("")%></li>
<li>name:[request.getParameter("name")]			<%=request.getParameter("name") %></li>
<li>name:[multipartRequest.getParameter("name")]<%=multipartRequest.getParameter("name") %></li>
<li>fileone:<%=multipartRequest.getFilesystemName("fileone") %></li>
<li>filetwo:<%=multipartRequest.getFilesystemName("filetwo") %></li>
</ul>








