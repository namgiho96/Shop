package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.Database;
import factory.Databasefactory;

public class CustomerDAOImpl implements CustomerDAO {
	private static CustomerDAOImpl instance = new CustomerDAOImpl();

	private CustomerDAOImpl() {
		dao = CustomerDAOImpl.getInstance();
	}

	public static CustomerDAOImpl getInstance() {
		return instance;
	}
	CustomerDAOImpl dao;
	

	@Override
	public void insertCustomer(CustomerDTO cust) {
		System.out.println(">>>>>>DTO 회원등록<<<<<<<");
		
		
		try {
			
			String sql = CustomerSQL.SIGNUP.toString();
			PreparedStatement ps = Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
		  	System.out.println("DB 진입 성공");
		  	ps.setString(1,cust.getCustomerID());
		  	ps.setString(2, cust.getCustomerName());
		  	ps.setString(3, cust.getPassword());
		  	ps.setString(4, cust.getAddress());
		  	ps.setString(5, cust.getCity());
		  	ps.setString(6, cust.getPostalCode());
		  	ps.setString(7, cust.getSsn());
		  	int res = ps.executeUpdate();
		  	
		  	if(res==1) {
		  		System.out.println("입력성공");
		  	}else {
		  		System.out.println("입력실패");
		  	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public List<CustomerDTO> selectCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO selectCustomer(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomer(CustomerDTO cust) {
		boolean ok = false;
		try {
			String sql = CustomerSQL.SIGNIN.toString();
			PreparedStatement ps = Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, cust.getCustomerID());
			ps.setString(2, cust.getPassword());
			
			if(ps.executeQuery().next()) {
				ok = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	@Override
	public void updateCustomer(CustomerDTO cust) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(CustomerDTO cust) {
		// TODO Auto-generated method stub

	}

}
