package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ImageDTO;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class RetrieveCommand extends Command  {

	public RetrieveCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		Proxy paging = new Pagination();
		Proxy pagepxy = new PageProxy();
		paging.carryOut(request);
		pagepxy.carryOut(paging);
		CustomerDTO cust = new CustomerDTO();
		cust.setCustomerID(request.getParameter("customerID"));
		ImageDTO img = new ImageDTO();
		cust = CustomerServiceImpl.getInstance().retriveCustomer(cust);
		request.setAttribute("cust",cust);
		request.setAttribute("img",img);

	}
}
