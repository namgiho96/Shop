package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Proxy;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerServiceImpl instance = new CustomerServiceImpl();

	private CustomerServiceImpl() {
		dao = CustomerDAOImpl.getInstance();
	}

	public static CustomerServiceImpl getInstance() {
		return instance;
	}

	CustomerDAO dao;

	@Override
	public void addCustomer(CustomerDTO cust) {
		dao.insertCustomer(cust);
		
	}

	@Override
	public List<CustomerDTO> bringCustomer(Proxy pxy) {
		
		return dao.selectCustomer(pxy);
	}

	@Override
	public List<CustomerDTO> retriveCustomers(Proxy pxy) {
		return null;
	}

	@Override
	public CustomerDTO retriveCustomer(CustomerDTO cust) {
		return dao.retriveCustomer(cust);
	}

	@Override
	public int countCustomer(Proxy pxy) {
		return dao.countCustomer(pxy);
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cust) {
		return	dao.existsCustomerID(cust);
	}

	@Override
	public void modfyCustomer(CustomerDTO cust) {
		dao.updateCustomer(cust);
	}

	@Override
	public void removeCustomer(CustomerDTO cust) {
		dao.deleteCustomer(cust);
	}

	@Override
	public Map<String, Object> retrievePhone(Proxy pxy) {
		
		return dao.SelectPhone(pxy);
	}

	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		return dao.selectProfile(pxy);
	}

}
