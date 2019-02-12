package service;

import java.util.List;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Pagination;

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
	public List<CustomerDTO> bringCustomer(Pagination page) {
		
		return dao.selectCustomer(page);
	}

	@Override
	public List<CustomerDTO> retriveCustomers(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retriveCustomer(CustomerDTO cust) {
		// TODO Auto-generated method stub
		return dao.selectCustomer(cust);
	}

	@Override
	public int countCustomer() {
		return dao.countCustomer();
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cust) {
		return	dao.existsCustomerID(cust);
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
