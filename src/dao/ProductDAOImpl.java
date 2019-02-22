package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import enums.Vendor;
import factory.Databasefactory;
import proxy.Proxy;

public class ProductDAOImpl implements ProductDAO {

	private static ProductDAOImpl instance = new ProductDAOImpl();
	Connection conn;
	private ProductDAOImpl() {
		conn = Databasefactory
		.createDatabase(Vendor.ORACLE)
		.getConnection();
	}
	public static ProductDAOImpl getInstance() {
		return instance;
	}
	ProductDAOImpl dao;
	
	@Override
	public void insertproduct(ProductDTO prod) {
		
		try {
			String sql = "";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setString(1, "");
			ps.setString(2, "");
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ProductDTO> selectproduct(Proxy pxy) {
		
		return null;
	}

	@Override
	public List<ProductDTO> selectproducts(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO selectproduct(ProductDTO prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO retriveproduct(ProductDTO prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countproduct(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsproductID(ProductDTO prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateproduct(ProductDTO prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> selectProfile(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteproduct(ProductDTO prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> SelectPhone(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

}
