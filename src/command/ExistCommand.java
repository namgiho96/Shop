package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {

	public ExistCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		HttpSession session = request.getSession();
		System.out.println("ExistCommand::들어옴");
		System.out.println("CMD는 ::"+Action.valueOf(request.getParameter("cmd").toUpperCase()));
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			
			emp.setEmployeeID(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existEmployee(emp);
			if (exist) {
				
				Proxy paging = new Pagination();
				paging.carryOut(request);
				Proxy pagepxy = new PageProxy();
				pagepxy.carryOut(paging);
				List<CustomerDTO> list = CustomerServiceImpl.getInstance()
				.bringCustomer(pagepxy);
				request.setAttribute("list",list);
				System.out.println("");
				
			} else {
				System.out.println("접근 불가");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;
		case SIGNIN:
			
			CustomerDTO cust = new CustomerDTO();
			cust.setCustomerID(request.getParameter("custmerID"));
			cust.setPassword(request.getParameter("password"));
			cust = CustomerServiceImpl.getInstance().retriveCustomer(cust);
			
			if(cust != null) {
				System.out.println("접근허용");
				session.setAttribute("customer",cust);
			}else {
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
			
		default:
			break;
		}

		System.out.println("ExistCommand 내부: " + super.getView());

	}

}
