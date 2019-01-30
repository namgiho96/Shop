package service;

import java.util.List;

import domain.CategoryDTO;

public interface CategoryService {

	public void createcategory(CategoryDTO cate);

	public List<CategoryDTO> bringcreategory();

	public List<CategoryDTO> retrivecreategorys(String serachWord);

	public CategoryDTO retrivecategory(String serachWord);

	public int countcategory();

	public boolean existcategory(String serachWord);

	public void modfycategory(CategoryDTO cate);

	public void removecategory(CategoryDTO cate);
}
