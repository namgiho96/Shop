package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cust);

	public List<CustomerDTO> selectCustomer();

	public List<CustomerDTO> selectCustomers(String serachWord);

	public CustomerDTO selectCustomer(CustomerDTO cust);

	public int countCustomer();

	public boolean existsCustomerID(CustomerDTO cust);

	public void updateCustomer(CustomerDTO cust);

	public void deleteCustomer(CustomerDTO cust);
}
