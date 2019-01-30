package dao;

import java.util.List;

import domain.OrderDetailDTO;

public class OrderDetailDAOImpl  implements OrderDetailDAO{
	private static OrderDetailDAOImpl instance = new OrderDetailDAOImpl();
	private  OrderDetailDAOImpl() {dao = OrderDetailDAOImpl.getInstance();}
	public static OrderDetailDAOImpl getInstance() {
		return instance;
	}
	OrderDetailDAOImpl dao;

	@Override
	public void insertOrderDeail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetailDTO> selectOrderDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDTO> selectOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailDTO selectsOrderDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrderDetail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateOrderDetail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteOrderDetail() {
		// TODO Auto-generated method stub
		
	}
	
}
