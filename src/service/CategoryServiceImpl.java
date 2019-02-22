package service;

import java.util.List;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import domain.CategoryDTO;
import proxy.Proxy;

public class CategoryServiceImpl implements CategoryService{
	
	private static CategoryServiceImpl instance = new CategoryServiceImpl();
	private  CategoryServiceImpl() { dao = CategoryDAOImpl.getInstance();}
	public static CategoryServiceImpl getInstance() {return instance;}
	
	CategoryDAO dao;

	@Override
	public void createcategory(CategoryDTO cate) {
		
	}
	@Override
	public List<?> bringcreategory(Proxy pxy) {
		return dao.selectcreategory(pxy);
	}

	@Override
	public List<CategoryDTO> retrivecreategorys(String serachWord) {
		return null;
	}

	@Override
	public CategoryDTO retrivecategory(String serachWord) {
		return null;
	}

	@Override
	public int countcategory() {
		return 0;
	}

	@Override
	public boolean existcategory(String serachWord) {
		return false;
	}

	@Override
	public void modfycategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removecategory(CategoryDTO cate) {
		
	}

}
