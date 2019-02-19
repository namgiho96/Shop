package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.ImageDTO;
import enums.Vendor;
import factory.Databasefactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO {

	private static ImageDAOImpl instens = new ImageDAOImpl();

	private ImageDAOImpl() {
		dao = ImageDAOImpl.getInstens();
	}
	public static ImageDAOImpl getInstens() {
		return instens;
	}
	ImageDAOImpl dao;
		
	
	@Override
	public void insertImage(ImageDTO img) {
	String	sql = "";
		try {
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
		
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<ImageDTO> selectimageList(Proxy pxy) {
		return null;
	}

	@Override
	public List<ImageDTO> selectimageLists(Proxy pxy) {
		return null;
	}

	@Override
	public ImageDTO retriveimage(ImageDTO img) {
		return null;
	}

	@Override
	public int countImage(Proxy pxy) {
		return 0;
	}

	@Override
	public void updateImage(ImageDTO img) {

	}

	@Override
	public void removeImage(ImageDTO img) {

	}
	@Override
	public String lastImageSeq() {
		return null;
	}

}
