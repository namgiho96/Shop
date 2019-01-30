package service;

import java.util.List;

import domain.OrderDTO;
import domain.OrderDetailDTO;

public interface OrderDetailService {
	public void addOrderDeail();

	public List<OrderDetailDTO> bringOrderDetail();

	public List<OrderDetailDTO> retriveOrderDetails();

	public OrderDetailDTO retriveOrderDetail();

	public int countOrderDetail();

	public boolean existOrderDetail();

	public void modfyOrderDetail();
}
