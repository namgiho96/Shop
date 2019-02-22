package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.Databasefactory;
import proxy.ImageProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerDAOImpl implements CustomerDAO {
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	Connection conn;
	private CustomerDAOImpl() {
		conn = Databasefactory
		.createDatabase(Vendor.ORACLE)
		.getConnection();
	}
	public static CustomerDAOImpl getInstance() {
		return instance;
	}
	CustomerDAOImpl dao;
	@Override
	public void insertCustomer(CustomerDTO cust) {
		System.out.println(">>>>>>DTO 회원등록<<<<<<<");
		
		try {
			/*
			"INSERT INTO CUSTOMERS(CUSTOMER_ID,"
					+ "CUSTOMER_NAME,"
					+ "PASSWORD,"
					+ "SSN,"
					+ "PHONE,"
					+ "POSTALCODE,"
					+ "CITY,"
					+ "ADDRESS,"
					+ "PHOTO)"*/
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
		  	ps.executeUpdate();
	
		} catch (Exception e) {
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
		
		try {
			
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.CUST_UPDATE.toString());
			ps.setString(1,cust.getCustomerID());
			ps.setString(2,cust.getPassword());
			ps.setString(3,cust.getPhone());
			ps.setString(4,cust.getCity());
			ps.setString(5,cust.getAddress());
			ps.setString(6,cust.getPostalCode());
			 ps.executeUpdate();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer(CustomerDTO cust) {
		
		try {
			PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.CUST_REMOVE.toString());
			ps.setString(1,cust.getCustomerID());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 
 
		
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
			e.printStackTrace();
		}
		
		
		return map;
	}

	@Override
	public CustomerDTO retriveCustomer(CustomerDTO cust) {
		System.out.println(cust.getCustomerID()+"다오 들어온 아이디");
		CustomerDTO cus = null;
		try {
			
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.CUST_RETRIEVE.toString());
			ps.setString(1,cust.getCustomerID());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cus = new CustomerDTO();
				cus.setAddress(rs.getString("ADDRESS"));
				cus.setCity(rs.getString("CITY"));
				cus.setCustomerID(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setPhone(rs.getString("PHONE"));
				cus.setPostalCode(rs.getString("POSTALCODE"));
				cus.setSsn(rs.getString("SSN"));
				cus.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return cus;
	}

	@Override
	public Map<String, Object> selectProfile(Proxy pxy) {
		Map<String, Object> map = new HashMap<String, Object>();
		CustomerDTO cust = new CustomerDTO();
		ImageDTO image = new ImageDTO();
	try {
		
		String sql = "";
		
		ImageProxy ipxy =  (ImageProxy) pxy;
		ImageDAOImpl.getInstens()
				.insertImage(((ImageProxy)pxy)
				.getImg());
		String imgSeq = ImageDAOImpl.getInstens().lastImageSeq();
		
		 sql = "UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ?";
		 
		 PreparedStatement ps =	conn.prepareStatement(sql);
			ps.setString(1,imgSeq);
			ps.setString(2,ipxy.getImg().getOwner());
			ps.executeUpdate();

			cust.setCustomerID(ipxy.getImg().getOwner());
			cust = retriveCustomer(cust);
			map.put("cust", cust);
			
			
			image.setImgSeq(imgSeq);
			image = ImageDAOImpl.getInstens().selectimage(image);
			map.put("image",image);
			
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
	}

}
