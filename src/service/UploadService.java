package service;

import java.io.File;
import java.io.IOException;

import model.FileUpload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {


	public FileUpload fileSetting(MultipartFile mfile, String realPath) {

		//file을 업로드 하려고 하는 폴더가 없으면 만들어준다. 
		File folder = new File(realPath);
		if(!folder.exists()){
			folder.mkdir();
		}
		
		FileUpload upload = new FileUpload(mfile);
		File file = new File(realPath + upload.getName());//
		try {
			mfile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return upload;
		
		
	}

	public boolean isImgFile(MultipartFile file) {
		String contentType = file.getContentType();
		if(contentType.startsWith("image/")|| file.isEmpty())
			return true;
		else
			return false;
		
	}

	
	
	
	

}
