package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println((request.getServletPath().split("/")[1].replace(".do",""))+">>>>1.상품 컨트롤러 진입<<<<<<<");
		Receiver.init(request,response);
		Carrier.forward(request, response);
		
	}

}
