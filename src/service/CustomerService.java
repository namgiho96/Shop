package service;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerService {

	public void addCustomer(CustomerDTO cust);

	public List<CustomerDTO> bringCustomer();

	public List<CustomerDTO> retriveCustomers(String serachWord);

	public CustomerDTO retriveCustomer(String serachWord);

	public int countCustomer();

	public boolean existCustomer(String serachWord);

	public void modfyCustomer(CustomerDTO cust);

	public void removeCustomer(CustomerDTO cust);
}
