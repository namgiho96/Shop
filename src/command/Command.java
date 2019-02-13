package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import lombok.Data;
import proxy.Proxy;
import proxy.RequestProxy;

@Data
public class Command implements Order {
	protected HttpServletRequest request;
	protected String action, domain, page, view;

	public Command(Map<String,Proxy> pxy) {
		System.out.println("-------3.Command()------");
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		setRequest(request);
		
		setAction(request.getParameter("cmd"));
		String dir = request.getParameter("dir");
		if (dir == null) {
			setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
		} else {
			setDomain(dir);
		}
		setPage(request.getParameter("page"));
		execute();
	}

	public Command() {
	}

	@Override
	public void execute() {
		this.view = "/WEB-INF/view/" + domain + "/" + page + ".jsp";
	}

}
