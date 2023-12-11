package com.itwill.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IfTag extends TagSupport{
	
	private boolean test;
	
	public IfTag() {
		System.out.println("1.IfTag 기본생성자");
	}
	
	public void setTest(boolean test) {
		System.out.println("2.setTest("+test+")");
		this.test = test;
	}
	
	@Override
	public int doStartTag() throws JspException {
		if(test) {
			return EVAL_BODY_INCLUDE; // 커스텀 태그가 내부 내용을 처리하고 출력해야할때 사용한다.
		} else {
			return SKIP_BODY; // 커스텀 태그가 내부 내용을 무시하고 출력하지 않아야 할때 사용한다.	
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
		/*
		 doStartTag 에서 결과 값을 반환하고, doEndTag 에서 EVAL_PAGE 를 반환함으로써 JSP 페이지의 남은 부분을 정상적으로 처리하고 출력할수있다.
		 */
	}
	
}
