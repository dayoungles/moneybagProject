package service;

import java.io.File;
import java.io.IOException;

import model.FileUpload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {


	public FileUpload fileSetting(MultipartFile mfile, String realPath) {

		FileUpload upload = new FileUpload(mfile);
		/*
		 * maven profile, spring environment
		 * local에서 사용하는 설정파일과 실서버에서 사용하는 설정 파일을 따로 설정할 수 있음.
		 */
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
