package service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import model.FileUpload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
	public static HttpServletRequest request;
	private static String path; 

	private void makePath(String realPath){
		this.path = request.getSession().getServletContext().getRealPath("/");
	}

	/**
	 * file upload. 업로드할 위치 
	 * @param mfile
	 * @param realPath
	 * @return
	 */
	public FileUpload uploadFile(MultipartFile mfile, String filePos) {
		if(isImgFile(mfile) == false){
			return null;//exception 발생 시키라는데..익셉션을 피해갈 방법은 정녕 없는 것인가 
		}
		//file을 업로드 하려고 하는 폴더가 없으면 만들어준다. 
		File folder = new File(filePos);
		if(!folder.exists()){
			folder.mkdir();
		}
		makePath(filePos);
		FileUpload upload = new FileUpload(mfile);
		File file = new File(path+filePos + upload.getName());//
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
