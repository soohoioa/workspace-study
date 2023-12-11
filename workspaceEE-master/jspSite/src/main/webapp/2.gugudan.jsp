<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>방가워요 JSP</TITLE>
<link rel="stylesheet" type="text/css" href="css/common.css">
</HEAD>
<BODY>
	<center>
		<H2>JSP 구구단[스크립렛 &lt;% %&gt;]</H2>

		<img src='tomcat.svg' />
		<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600
			cellspacing=0>
			<% for(int i = 2; i <= 9; i++) { %>
			<tr>
				<% for(int j = 1; j <= 9; j++) { %>
					<td align=center><%out.print(i);%>*<%out.print(j);%>=<%out.print(i*j);%></td>
				<% } %>
			</tr>
			<% } %>
		</table>
		<hr>
		
		
		<H2>JSP 구구단[표현식 &lt;%= %&gt;]</H2>

		<img src='tomcat.svg' />
		<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600
			cellspacing=0>
			<% for(int i = 2; i <= 9; i++) { %>
			<tr>
				<% for(int j = 1; j <= 9; j++) { %>
					<td align=center>
						<%=i%>*<%=j%>=<%=i*j%>
					</td>
				<% } %>
			</tr>
			<% } %>
		</table>
		<hr>
		<jsp:include page="6-2.action_tag_included_footer.jsp"/>
		
		
	</center>
	<br />

</BODY>
</HTML>
