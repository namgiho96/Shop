package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand  extends Command{
	
	public UpdateCommand(Map<String, Proxy> pxy) {
		
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		CustomerDTO cust = new CustomerDTO();
		String customerID = request.getParameter("customer_id");
		cust.setCustomerID(customerID);
		cust = CustomerServiceImpl.getInstance().retriveCustomer(cust);
		
		 
		   if(!request.getParameter("phone").equals(""))
			   cust.setPhone(request.getParameter("phone"));
		   
	        if(!request.getParameter("postalCode").equals(""))
	        	cust.setPostalCode(request.getParameter("postalCode"));
	        
	        if(!request.getParameter("city").equals(""))
	        	cust.setCity(request.getParameter("city"));
	        
	        if(!request.getParameter("address").equals(""))
	        	cust.setAddress(request.getParameter("address"));
	        
	        if(!request.getParameter("password").equals(""))
	        	cust.setPassword(request.getParameter("password"));
	    	CustomerServiceImpl.getInstance().modfyCustomer(cust);
	        
	        request.setAttribute("cust",cust);
		System.out.println("수정하려는 회원의 정보:"+cust.toString());
		

		
	}
	
}
