package service;

import java.io.File;
import java.io.IOException;

import model.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	

	public FileUpload fileSetting(MultipartFile mfile) {
		
		FileUpload upload = new FileUpload(mfile);
		File file = new File("/userImg/"+ upload.getName());
		try {
			mfile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return upload;
		
		
	}
	
	
	
	

}
