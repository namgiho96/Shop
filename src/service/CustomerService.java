package service;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerService {

	public void addCustomer(CustomerDTO cust);

	public List<CustomerDTO> bringCustomer();

	public List<CustomerDTO> retriveCustomers(String serachWord);

	public CustomerDTO retriveCustomer(CustomerDTO cust);

	public int countCustomer();

	public boolean existsCustomerID(CustomerDTO cust);

	public void modfyCustomer(CustomerDTO cust);

	public void removeCustomer(CustomerDTO cust);
}
