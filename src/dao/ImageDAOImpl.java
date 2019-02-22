package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.ImageDTO;
import enums.ImageSQL;
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
		try {
			System.out.println("insertImage::들어옴");
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(ImageSQL.IMAGE_INSERT.toString());
		System.out.println(img.getImgName());
			ps.setString(1,img.getImgName());
			ps.setString(2,img.getImgExtention());
			ps.setString(3,img.getOwner());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ImageDTO selectimage(ImageDTO img) {
		ImageDTO image = new ImageDTO();
	try {
		String sql = "SELECT * FROM IMAGE WHERE IMG_SEQ LIKE ?";
		PreparedStatement ps =	Databasefactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
		ps.setString(1, img.getImgSeq());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			image.setOwner(rs.getString("OWNER"));
			image.setImgName(rs.getString("IMG_NAME"));
			image.setImgSeq(rs.getString("IMG_SEQ"));
			image.setImgExtention(rs.getString("IMG_EXTENTION"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return image;
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
		String seq = "";
		try {
			
			PreparedStatement ps = 
					Databasefactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ImageSQL.IMAGE_SEQ.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				seq = rs.getString("IMG_SEQ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seq;
	}

}
