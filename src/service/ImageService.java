package service;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageService {
	public void addImage(ImageDTO img);

	public List<ImageDTO> imageList(Proxy pxy);

	public List<ImageDTO> imageLists(Proxy pxy);

	public ImageDTO retriveimage(ImageDTO img);

	public int countImage(Proxy pxy);
	
	public void updateImage(ImageDTO img);

	public void removeImage(ImageDTO img);
}
