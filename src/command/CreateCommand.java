package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command{
	
	public CreateCommand(HttpServletRequest request, 
			HttpServletResponse response) {
		super(request, response);
		System.out.println("-------크레에이트 커맨드 들어옴--------");
		EmployeeDTO empd = new EmployeeDTO();
		empd.setPhoto(request.getParameter("Photo"));
		empd.setName(request.getParameter("name"));
		empd.setManager(request.getParameter("manager"));
		empd.setBirthDate(request.getParameter("birthday"));
		empd.setNotes(request.getParameter("Notes"));
		EmployeeServiceImpl.getInstance().registEmployee(empd);
	}
}
