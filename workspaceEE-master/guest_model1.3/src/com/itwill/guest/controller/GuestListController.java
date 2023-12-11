package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.spring.mvc.Controller;

public class GuestListController implements Controller{
	private GuestService guestService;
	public GuestListController(){
		try {
			guestService=new GuestService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 반드시 handleRequest 에 의해서 forwardPath 를 반환한다.
		String forwardPath ="";
		try {
			List<Guest> guestList = guestService.findAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		
		return forwardPath;
	}
	
	
}