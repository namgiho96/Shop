package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {

	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>>>3. 커맨더 진입<<<<<<<");
		
		Command cmd = null;
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE:
			System.out.println("COMMANDER :::::MOVE:::: 로온다");
			cmd = new Command(request,response);
			break;
		case REGISTER:case SIGNUP:
			System.out.println("COMMANDER:::::REGISTER/SIGNUP:::: 로온다");
			cmd = new CreateCommand(request, response);
			break;
		case ACCESS:case SIGNIN:
			System.out.println("COMMANDER:::::ACCESS/SIGNIS:::: 로온다");
			cmd = new ExistCommand(request, response);
			break;
			
		case CUST_LIST:
			System.out.println("COMMANDER::::LIST 로 온다");
			cmd = new ListCommand(request, response);
		default:
			break;
		}
		System.out.println("커맨더 내: "+Receiver.cmd.getView());
		return cmd;

	}

}
