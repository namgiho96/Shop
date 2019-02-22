package service;

import java.util.List;
import java.util.Map;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import domain.ProductDTO;
import proxy.Proxy;

public class ProductServiceImpl implements ProductService{
	
	private static ProductServiceImpl instance = new ProductServiceImpl();

	private ProductServiceImpl() {
		dao = ProductDAOImpl.getInstance();
	}
	public static ProductServiceImpl getInstance() {
		return instance;
	}
	ProductDAO dao;
	
	
	@Override
	public void addprodomer(ProductDTO prod) {
		dao.insertproduct(prod);
	}

	@Override
	public List<ProductDTO> bringprodomer(Proxy pxy) {
		return dao.selectproduct(pxy);
	}

	@Override
	public List<ProductDTO> retriveprodomers(Proxy pxy) {
		return null;
	}

	@Override
	public ProductDTO retriveprodomer(ProductDTO prod) {
		return null;
	}

	@Override
	public int countprodomer(Proxy pxy) {
		return 0;
	}

	@Override
	public boolean existsprodomerID(ProductDTO prod) {
		return false;
	}

	@Override
	public void modfyprodomer(ProductDTO prod) {
	}

	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		return null;
	}

	@Override
	public void removeprodomer(ProductDTO prod) {
	}

	@Override
	public Map<String, Object> retrievePhone(Proxy pxy) {
		return null;
	}

}
