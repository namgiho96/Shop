package service;

import java.util.List;

import domain.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerServiceImpl instance = new CustomerServiceImpl();

	private CustomerServiceImpl() {
		dao = CustomerServiceImpl.getInstance();
	}

	public static CustomerServiceImpl getInstance() {
		return instance;
	}

	CustomerServiceImpl dao;

	@Override
	public void addCustomer(CustomerDTO cust) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CustomerDTO> bringCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> retriveCustomers(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retriveCustomer(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existCustomer(String serachWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modfyCustomer(CustomerDTO cust) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCustomer(CustomerDTO cust) {
		// TODO Auto-generated method stub

	}

}
