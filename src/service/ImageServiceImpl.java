package service;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDAOImpl;
import dao.ImageDAO;
import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl  implements ImageService{

	private static ImageServiceImpl instens = new ImageServiceImpl();
	
	private ImageServiceImpl() {
		
		dao = ImageDAOImpl.getInstens();
	}
	public static ImageServiceImpl getInstens() {
		return instens;
	}
	
	ImageDAO dao;
	
	@Override
	public void addImage(ImageDTO img) {
		dao.insertImage(img);
	}
	
	
	
	
	@Override
	public ImageDTO selectimage(ImageDTO img) {
		return dao.selectimage(img);
	}

	@Override
	public List<ImageDTO> imageLists(Proxy pxy) {
		List<ImageDTO> list = new ArrayList<>();
		
		return list;
	}

	@Override
	public ImageDTO retriveimage(ImageDTO img) {
		ImageDTO imag = new ImageDTO();
		
		return imag;
	}

	@Override
	public int countImage(Proxy pxy) {
		int rs = 0;
		
		return rs;
	}

	@Override
	public void removeImage(ImageDTO img) {
		
	}

	@Override
	public void updateImage(ImageDTO img) {
		
	}

}
