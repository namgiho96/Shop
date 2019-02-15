package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.Databasefactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

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
	public List<CustomerDTO> selectCustomer(Proxy pxy) {
		System.out.println("selectcustmoer 들어옴:");
		List<CustomerDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			System.out.println("DAOIMPL ::"+page);
		PreparedStatement ps =	Databasefactory
				.createDatabase(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(CustomerSQL.LIST.toString());
		
		String StartRow = String.valueOf(page.getStartRow());
		String endRow = String.valueOf(page.getEndRow());
		
		System.out.println("DAO_startRow:: "+StartRow);
		System.out.println("DAO_EndRow:: "+endRow);
		
			ps.setLong(1,page.getStartRow());
			ps.setLong(2,page.getEndRow());
		
			ResultSet rs = ps.executeQuery();
			CustomerDTO cust = null;
			while(rs.next()) {
				System.out.println("while문을 탐");
				cust = new CustomerDTO();
				cust.setRownum(rs.getString("RNUM"));
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
	public List<CustomerDTO> selectCustomers(Proxy pxy) {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int countCustomer(Proxy pxy) {
		int res = 0;
		try {
			String sql = CustomerSQL.ROW_COUNT.toString();
		PreparedStatement ps = Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			res = rs.getInt("count");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
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

	@Override
	public Map<String, Object> SelectPhone(Proxy pxy) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		 try {
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.PHONE_LIST.toString());
		ResultSet rs =	ps.executeQuery();
		CustomerDTO cust = null;
		while(rs.next()) {
			cust = new CustomerDTO();
			String entry = rs.getString("CUSTOMER_ID");
			cust.setCustomerID(rs.getString("CUSTOMER_ID"));
			cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
			cust.setPhone(rs.getString("PHONE"));
			
			map.put(entry,cust);
			
			System.out.println("이름"+map.put("name",rs.getObject("CUSTOMER_NAME")));
			System.out.println("전화번호"+map.put("phone",rs.getObject("PHONE")));
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return map;
	}

	@Override
	public CustomerDTO retriveCustomer(CustomerDTO cust) {
		CustomerDTO cus = new CustomerDTO();
		try {
			
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.CUST_RETRIEVE.toString());
			ps.setString(1,cust.getCustomerID());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cus.setAddress(rs.getString("ADDRESS"));
				cus.setCity(rs.getString("CITY"));
				cus.setCustomerID(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setPhone(rs.getString("PHONE"));
				cus.setPostalCode(rs.getString("POSTALCODE"));
				cus.setSsn(rs.getString("SSN"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return cus;
	}

}
