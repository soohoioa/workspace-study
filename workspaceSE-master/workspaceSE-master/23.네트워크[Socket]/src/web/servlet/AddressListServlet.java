package web.servlet;

import java.io.PrintWriter;
import java.util.List;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

public class AddressListServlet {
	
	public void service(PrintWriter out) throws Exception{
		AddressService addressService=new AddressService();
		List<Address> addressList= addressService.addressList();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		for(Address address:addressList) {
			out.println("<li>["+address.getNo()+"]"+address.getName()+"</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
