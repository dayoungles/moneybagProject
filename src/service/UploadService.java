package service;

import java.io.File;
import java.io.IOException;

import model.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	

	public FileUpload fileSetting(FileUpload upfile, int userId) {
		if(upfile.getFile() == null || upfile.getFile().getSize() == 0){
			upfile.setName(0);
		} else {
			upfile.setName(userId);
		}
		File file = new File("/userImg/"+ upfile.getName());
		
		try {
			upfile.getFile().transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return upfile;
				
	}
	
	
	
	

}
