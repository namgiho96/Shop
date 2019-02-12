package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command{
	
	public CreateCommand(HttpServletRequest request, 
			HttpServletResponse response) {
			super(request, response);
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case REGISTER:
			System.out.println("-------크레에이트 커맨드 들어옴--------");
			EmployeeDTO empd = new EmployeeDTO();
			empd.setPhoto(request.getParameter("Photo"));
			empd.setName(request.getParameter("name"));
			empd.setManager(request.getParameter("manager"));
			empd.setBirthDate(request.getParameter("birthday"));
			empd.setNotes(request.getParameter("Notes"));
			EmployeeServiceImpl.getInstance().registEmployee(empd);
			break;
		case SIGNUP:
			CustomerDTO cust = new CustomerDTO();
			cust.setAddress(request.getParameter("address"));
			cust.setCity(request.getParameter("city"));
			cust.setCustomerID(request.getParameter("custmerID"));
			cust.setCustomerName(request.getParameter("customerName"));
			cust.setPassword(request.getParameter("password"));
			cust.setPostalCode(request.getParameter("postalCode"));
			cust.setPhoto(request.getParameter("phone"));
			cust.setSsn(request.getParameter("ssn"));
			CustomerServiceImpl.getInstance().addCustomer(cust);
		default:
			break;
		}
		
	}
}
