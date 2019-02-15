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
		Proxy pagepxy = new PageProxy();
		paging.carryOut(request);
		pagepxy.carryOut(paging);
		System.out.println("------리스트 커맨트탑니다----");
		List<CustomerDTO> list  = CustomerServiceImpl.getInstance().bringCustomer(pagepxy);
		request.setAttribute("list",list);
		request.setAttribute("pagination",paging);
		
		
		
		
		
	}


}
