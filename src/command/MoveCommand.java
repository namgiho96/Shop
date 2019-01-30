package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveCommand extends Command {
	public MoveCommand(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>>>4. 무브 커맨더<<<<<<<");
		setRequest(request);
		setAction(request.getParameter("cmd"));
		setDomain(request.getServletPath().split("/")[1].replace(".do",""));
		setPage(request.getParameter("page"));
		execute();
	}
}
