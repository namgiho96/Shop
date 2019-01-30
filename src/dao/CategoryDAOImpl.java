package dao;

import java.util.List;

import domain.CategoryDTO;

public class CategoryDAOImpl implements CategoryDAO {

	private static CategoryDAOImpl instance = new CategoryDAOImpl();

	private CategoryDAOImpl() {
		dao = CategoryDAOImpl.getInstance();
	}

	public static CategoryDAOImpl getInstance() {
		return instance;
	}

	CategoryDAOImpl dao;

	@Override
	public void insertcategory(CategoryDTO cate) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CategoryDTO> selectcreategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> selectcreategorys(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO selectcategory(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countcategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existcategory(String serachWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updatacategory(CategoryDTO cate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletecategory(CategoryDTO cate) {
		// TODO Auto-generated method stub

	}

}
