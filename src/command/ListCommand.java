package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class ListCommand  extends Command{
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		Proxy paging = new Pagination();
		paging.carryOut(request);
		
		Proxy pagepxy = new PageProxy();
		pagepxy.carryOut(paging);
		
		
		List<CustomerDTO> list  = CustomerServiceImpl.getInstance().bringCustomer(pagepxy);
		request.setAttribute("list",list);
		System.out.println("1 =" +request.getParameter("cmd"));
		System.out.println("2 =" +request.getParameter("page"));
		System.out.println("3 =" +request.getParameter("page_num"));
		System.out.println("4 =" +request.getParameter("page_size"));
		
		
		
		
		
	}


}
