package dao;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageDAO {

	public void insertImage(ImageDTO img);

	public List<ImageDTO> selectimageList(Proxy pxy);

	public List<ImageDTO> selectimageLists(Proxy pxy);

	public ImageDTO retriveimage(ImageDTO img);
	
	public String lastImageSeq();

	public int countImage(Proxy pxy);
	
	public void updateImage(ImageDTO img);

	public void removeImage(ImageDTO img);
}
