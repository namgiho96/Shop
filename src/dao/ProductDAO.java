package dao;

import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import proxy.Proxy;

public interface ProductDAO {
	public void insertproduct(ProductDTO prod);

	public List<ProductDTO> selectproduct(Proxy pxy);

	public List<ProductDTO> selectproducts(Proxy pxy);

	public ProductDTO selectproduct(ProductDTO prod);
	
	public ProductDTO retriveproduct(ProductDTO prod);

	public int countproduct(Proxy pxy);

	public boolean existsproductID(ProductDTO prod);

	public void updateproduct(ProductDTO prod);

	public Map<String, Object> selectProfile(Proxy pxy);

	public void deleteproduct(ProductDTO prod);

	public Map<String, Object> SelectPhone(Proxy pxy);

}
