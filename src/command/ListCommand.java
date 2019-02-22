package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CategoryDTO;
import domain.CustomerDTO;
import domain.ProductDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

public class ListCommand  extends Command{
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		String flag = request.getParameter("cmd");
		List<?> list = new ArrayList<>();
		
		switch (Action.valueOf(flag.toUpperCase())) {
		case CUST_LIST:
			Proxy paging = new Pagination();
			Proxy pagepxy = new PageProxy();
			paging.carryOut(request);
			pagepxy.carryOut(paging);
			System.out.println("------CUST 커맨트탑니다----");
			list  = CustomerServiceImpl.getInstance().bringCustomer(pagepxy);
			request.setAttribute("list",list);
			request.setAttribute("pagination",paging);
			break;
		case PRODUCT_LIST :
			 paging = new Pagination();
			 pagepxy = new PageProxy();
			paging.carryOut(request);
			pagepxy.carryOut(paging);
			System.out.println("------PRODUCT 커맨트탑니다----");
			list  = ProductServiceImpl.getInstance().bringprodomer(pagepxy);
			request.setAttribute("list",list);
			request.setAttribute("pagination",paging);
			break;
		case CATE_LIST:
			 paging = new Pagination();
			 pagepxy = new PageProxy();
			 paging.carryOut(request);
			 pagepxy.carryOut(paging);
			 System.out.println("------CATE 커맨트탑니다----");
			 list  =  CategoryServiceImpl.getInstance().bringcreategory(pagepxy);
			 request.setAttribute("list",list);
			 System.out.println("CATE_LIST ::"+list);
			break;
			
		default:
			break;
		}
		
	
		
		
		
		
		
	}


}
