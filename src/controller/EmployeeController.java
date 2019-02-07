package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println((request.getServletPath().split("/")[1].replace(".do",""))+">>>>1.사원 컨트롤러 진입<<<<<<<");
		Receiver.init(request,response);
			System.out.println((request.getServletPath().split("/")[1].replace(".do",""))+">>>>2.컨트롤러 진입 forward <<<<<<<");
		Carrier.forward(request, response);
		}
}
