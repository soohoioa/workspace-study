package com.itwill.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloAttributeTag extends TagSupport{
	private String irum;
	
	public HelloAttributeTag() {
		System.out.println("1.HelloAttributeTag 기본생성자");
	}
	
	
	public void setIrum(String irum) {
		System.out.println("2.setIrum("+irum+") 메소드가 호출 ");
		this.irum = irum;
	}


	@Override
	public int doStartTag() throws JspException {
		System.out.println("3.doStartTag() 메소드가 호출 ");
		
		try {
			String msg = "";
			if(irum.equals("홍길동")) {
				msg="잘생긴 " + irum + " 님 안녕하세요<br>";
			}else {
				msg=irum + " 님 안녕하세요<br>";				
			}
			pageContext.getOut().println(msg);
			pageContext.getOut().println("<hr>");
			
		} catch (Exception e) {
			
		}
		
		return super.doStartTag();
	}

	
	
	
	
}
