package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cust);

	public List<CustomerDTO> selectCustomer();

	public List<CustomerDTO> selectCustomers(String serachWord);

	public CustomerDTO selectCustomer(String serachWord);

	public int countCustomer();

	public boolean existsCustomer(String serachWord);

	public void updateCustomer(CustomerDTO cust);

	public void deleteCustomer(CustomerDTO cust);
}
