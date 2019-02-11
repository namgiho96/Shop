package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
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
		  	ps.setString(4, cust.getSsn());
		  	ps.setString(5, cust.getPhone());
		  	ps.setString(6, cust.getPostalCode());
		  	ps.setString(7, cust.getCity());
		  	ps.setString(8, cust.getAddress());
		  	
		  	int res = ps.executeUpdate();
		  	/*	CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTALCODE,CITY,ADDRESS*/
		  	
		  	if(res==1) {
		  		System.out.println("입력성공");
		  	}else {
		  		System.out.println("입력실패");
		  	}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public List<CustomerDTO> selectCustomer() {
		System.out.println("selectcustmoer 들어옴:");
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String  sql = CustomerSQL.LIST.toString();
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			CustomerDTO cust = null;
			
			while(rs.next()) {
				System.out.println("while문을 탐");
				cust = new CustomerDTO();
			/*	CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTALCODE,CITY,ADDRESS*/
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setCity(rs.getString("CITY"));
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setPassword(rs.getString("PASSWORD"));
				cust.setPhone(rs.getString("PHONE"));
				cust.setPostalCode(rs.getString("POSTALCODE"));
				cust.setSsn(rs.getString("SSN"));
				list.add(cust);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cust) {
		CustomerDTO dto = null;
		
		try {
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.SIGNIN.toString());
		ps.setString(1,cust.getCustomerID());
		ps.setString(2,cust.getPassword());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			dto = new CustomerDTO();
			dto.setAddress(rs.getString("ADDRESS"));
			dto.setCity(rs.getString("CITY"));
			dto.setCustomerID(rs.getString("CUSTOMER_ID"));
			dto.setCustomerName(rs.getString("CUSTOMER_NAME"));
			dto.setPassword(rs.getString("PASSWORD"));
			dto.setPostalCode(rs.getString("POSTALCODE"));
			dto.setPhone(rs.getString("PHONE"));
			dto.setSsn(rs.getString("SSN"));
			
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cust) {
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
