package service;

import java.util.List;

import domain.OrderDetailDTO;

public class OrderDetailServiceImpl implements OrderDetailService{
	private static OrderDetailServiceImpl instance = new OrderDetailServiceImpl();
	private OrderDetailServiceImpl() {}
	public static OrderDetailServiceImpl getInstance() {
		return instance;
	}

	@Override
	public void addOrderDeail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetailDTO> bringOrderDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDTO> retriveOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailDTO retriveOrderDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrderDetail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existOrderDetail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modfyOrderDetail() {
		// TODO Auto-generated method stub
		
	}

}
