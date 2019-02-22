package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

public class Commander {

	public static Command order(Map<String,Proxy> pxy) {
		System.out.println(">>>>3. 커맨더 진입<<<<<<<");
		
		Command cmd = null;
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
	
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE:
			System.out.println("COMMANDER :::::MOVE:::: 로온다");
			cmd = new Command(pxy);
			break;
		case REGISTER:case SIGNUP:
			System.out.println("COMMANDER:::::REGISTER/SIGNUP:::: 로온다");
			cmd = new CreateCommand(pxy);
			break;
		case ACCESS:case SIGNIN:
			System.out.println("COMMANDER:::::ACCESS/SIGNIS:::: 로온다");
			cmd = new ExistCommand(pxy);
			break;
			
		case CUST_LIST: case PRODUCT_LIST:
			System.out.println("COMMANDER::::LIST 로 온다");
			cmd = new ListCommand(pxy);
			break;
		case CUST_RETRIEVE:
			System.out.println("CUST_RETRIEVE:: 들어옴");
			cmd = new RetrieveCommand(pxy);
		default:
			break;
			
		case CUST_UPDATE:
			System.out.println("CUST_UPDATE::: 들어온다");
			cmd = new UpdateCommand(pxy);
			break;
			
		case CUST_FILE_UPLOAD:
			System.out.println("업로드 들어옴");
			cmd = new FileCommand(pxy);
			break;
		case CUST_REMOVE:
			cmd = new RemoveCommand(pxy);
			break;
		case CATE_LIST:
			cmd = new ListCommand(pxy);
			break;
		
		}
		
		System.out.println("커맨더 내: "+Receiver.cmd.getView());
		return cmd;

	}

}
