package dao;

import java.util.List;

import domain.CategoryDTO;

public interface CategoryDAO {
	public void insertcategory(CategoryDTO cate);

	public List<CategoryDTO> selectcreategory();

	public List<CategoryDTO> selectcreategorys(String serachWord);

	public CategoryDTO selectcategory(String serachWord);

	public int countcategory();

	public boolean existcategory(String serachWord);

	public void updatacategory(CategoryDTO cate);

	public void deletecategory(CategoryDTO cate);
}
