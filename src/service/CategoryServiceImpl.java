package service;

import java.util.List;

import domain.CategoryDTO;

public class CategoryServiceImpl implements CategoryService{
	private static CategoryServiceImpl instance = new CategoryServiceImpl();
	private  CategoryServiceImpl() { dao= CategoryServiceImpl.getInstance();}
	
	public static CategoryServiceImpl getInstance() {
		return instance;
	}
	CategoryServiceImpl dao;

	@Override
	public void createcategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryDTO> bringcreategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> retrivecreategorys(String serachWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO retrivecategory(String serachWord) {
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
	public void modfycategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removecategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}

}
