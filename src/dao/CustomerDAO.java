package dao;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cust);

	public List<CustomerDTO> selectCustomer(Proxy pxy);

	public List<CustomerDTO> selectCustomers(Proxy pxy);

	public CustomerDTO selectCustomer(CustomerDTO cust);
	
	public CustomerDTO retriveCustomer(CustomerDTO cust);

	public int countCustomer(Proxy pxy);

	public boolean existsCustomerID(CustomerDTO cust);

	public void updateCustomer(CustomerDTO cust);

	public CustomerDTO selectProfile(Proxy pxy);

	public void deleteCustomer(CustomerDTO cust);

	public Map<String, Object> SelectPhone(Proxy pxy);

}
