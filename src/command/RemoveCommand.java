package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class RemoveCommand extends Command {

	public RemoveCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		
		case CUST_REMOVE:
			System.out.println("rmove들어옴");
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerID(request.getParameter("customerID"));
			CustomerServiceImpl.getInstance()
				.removeCustomer(cust); 
		
			break;
		default:
			break;
		
	}
	}
}
