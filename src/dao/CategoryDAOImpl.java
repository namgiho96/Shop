package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.Databasefactory;
import proxy.Proxy;

public class CategoryDAOImpl implements CategoryDAO {

	private Connection conn;
	
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	private CategoryDAOImpl() {
		conn =   Databasefactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
	}
	public static CategoryDAOImpl getInstance() {return instance;}

	@Override
	public void insertcategory(CategoryDTO cate) {
		
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public List<CategoryDTO> selectcreategory(Proxy pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		CategoryDTO cate = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(CategorySQL.CATE_LIST.toString());
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				cate = new CategoryDTO();
				cate.setCategoryID(rs.getString("CATEGORY_ID"));
				cate.setCategoryName(rs.getString("CATEGORY_NAME"));
				cate.setDescription(rs.getString("DESCRIPTION"));
				list.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("다오임플 리스트 값::"+list);
		return list;
	}

	@Override
	public List<CategoryDTO> selectcreategorys(String serachWord) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryDTO selectcategory(String serachWord) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countcategory() {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean existcategory(String serachWord) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updatacategory(CategoryDTO cate) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletecategory(CategoryDTO cate) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
