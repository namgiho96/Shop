package service;

import java.util.List;

import domain.CustomerDTO;
import proxy.Pagination;

public interface CustomerService {

	public void addCustomer(CustomerDTO cust);

	public List<CustomerDTO> bringCustomer(Pagination page);

	public List<CustomerDTO> retriveCustomers(String serachWord);

	public CustomerDTO retriveCustomer(CustomerDTO cust);

	public int countCustomer();

	public boolean existsCustomerID(CustomerDTO cust);

	public void modfyCustomer(CustomerDTO cust);

	public void removeCustomer(CustomerDTO cust);
}
