package service;

import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import proxy.Proxy;

public interface ProductService {

	public void addprodomer(ProductDTO prod);

	public List<ProductDTO> bringprodomer(Proxy pxy);

	public List<ProductDTO> retriveprodomers(Proxy pxy);

	public ProductDTO retriveprodomer(ProductDTO prod);

	public int countprodomer(Proxy pxy);

	public boolean existsprodomerID(ProductDTO prod);

	public void modfyprodomer(ProductDTO prod);
	
	public Map<String, Object> fileUpload(Proxy pxy);

	public void removeprodomer(ProductDTO prod);
	
	public Map<String,Object> retrievePhone(Proxy pxy);
}
