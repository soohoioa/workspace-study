package com.itwill.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
	public HelloTag() {
		System.out.println("1.HelloTag 기본생성자");
	}
	// 여기서 주로 출력작업만 할꺼다.

	@Override
	public int doStartTag() throws JspException {
		System.out.println("2.doStartTag()호출");
		JspWriter out = pageContext.getOut();
		String sUserId = (String)pageContext.getSession().getAttribute("sUserId");
		if(sUserId == null) {
			sUserId="GUEST";
		}
		try {
			out.println(sUserId+" 님 안녕하세요<br>");
			
		} catch (IOException e) {
			throw new JspException(e.getMessage());			
		}
		
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("3.doEndTag()호출");
		try {
			pageContext.getOut().println("<hr>");
			
		} catch (IOException e) {
			throw new JspException(e.getMessage());			
		}
		return super.doEndTag();
	}
	
}
