package service;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerService {

	public void addCustomer(CustomerDTO cust);

	public List<CustomerDTO> bringCustomer(Proxy pxy);

	public List<CustomerDTO> retriveCustomers(Proxy pxy);

	public CustomerDTO retriveCustomer(CustomerDTO cust);

	public int countCustomer(Proxy pxy);

	public boolean existsCustomerID(CustomerDTO cust);

	public void modfyCustomer(CustomerDTO cust);
	
	public Map<String, Object> fileUpload(Proxy pxy);

	public void removeCustomer(CustomerDTO cust);
	
	public Map<String,Object> retrievePhone(Proxy pxy);
}
