package dao;

import java.util.List;

import domain.OrderDetailDTO;

public interface OrderDetailDAO {
	public void insertOrderDeail();

	public List<OrderDetailDTO> selectOrderDetail();

	public List<OrderDetailDTO> selectOrderDetails();

	public OrderDetailDTO selectsOrderDetail();

	public int countOrderDetail();

	public boolean updateOrderDetail();

	public void deleteOrderDetail();
}
