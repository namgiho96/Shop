package proxy;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.ImageDTO;
import enums.Props;
import lombok.Data;
@Data
public class ImageProxy implements Proxy{
	ImageDTO img;
	@Override
	public void carryOut(Object o) {
		System.out.println("이미지프록시-------1------");
		HttpServletRequest request = (HttpServletRequest)o;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 40);
		upload.setFileSizeMax(1024 * 1024 * 50);
		List<FileItem> items = null;
		
	
		try {
			File file = null;
			items = upload.parseRequest(new ServletRequestContext(request));
			Iterator<FileItem> iter = items.iterator();
			
			while(iter.hasNext()) {
				FileItem item = iter.next();
				if(!item.isFormField()) {
					String fileName = item.getName();
					file = new File(Props.IMAGE.getValue()+fileName);
					item.write(file);
					img = new ImageDTO();
					img.setImgName(fileName.substring(0,fileName.indexOf(".")));
					System.out.println("파일명"+fileName.substring(0,fileName.indexOf(".")));
					img.setImgExtention(fileName.substring(fileName.indexOf(".")+1));
					System.out.println("확장자"+fileName.substring(fileName.indexOf(".")+1));
					img.setOwner(request.getParameter("customerID"));
					System.out.println("이미지주인공"+request.getParameter("customerID"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
