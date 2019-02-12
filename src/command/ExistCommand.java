package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {

	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
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
				
				
				List<CustomerDTO> list = CustomerServiceImpl.getInstance()
				.bringCustomer(new Proxy().getPage());
				
				request.setAttribute("list",list);
				
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
