package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import proxy.Proxy;
import service.CustomerServiceImpl;

public class ListCommand  extends Command{
	public ListCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		
		List<CustomerDTO> list  = CustomerServiceImpl.getInstance().bringCustomer(new Proxy().getPage());
		request.setAttribute("list",list);
		System.out.println("1 =" +request.getParameter("cmd"));
		System.out.println("2 =" +request.getParameter("page"));
		System.out.println("3 =" +request.getParameter("page_num"));
		System.out.println("4 =" +request.getParameter("page_size"));
		
		
		
		
		
	}


}
