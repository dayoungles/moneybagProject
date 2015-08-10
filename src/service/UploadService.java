package service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import model.FileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
	private static final Logger logger = LoggerFactory.getLogger(UploadService.class);
	private static final String NO_FILE = "default.png";
	public static String path;
	
//	private String uploadPath;
//	
//	@Value("${upload.path}")
//	public void setUploadPath(String uploadPath) {
//		this.uploadPath = uploadPath;
//	}
	
	
	/**
	 * file upload. 업로드할 위치
	 * 
	 * @param mfile
	 * @param request
	 * @param filePos
	 *            ; 파일이 들어갈 폴더명
	 * @return
	 * @throws Exception 
	 */
	public FileUpload uploadFile(MultipartFile mfile, String filePos) throws Exception {
		if (isImgFile(mfile) == false) {
			throw new Exception("not img file");
		}
		// file을 업로드 하려고 하는 폴더가 없으면 만들어준다.
		File folder = new File(this.path+filePos);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		FileUpload upload = new FileUpload(mfile);
		String path = this.path+filePos+upload.getName();
		logger.debug(path+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		if(upload.getName().equals(NO_FILE)){
			logger.info("default?");
			return upload;
		}
		
		File file = new File(this.path + filePos+ upload.getName());
		
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
		if (contentType.startsWith("image/") || file.isEmpty())
			return true;
		else
			return false;

	}

}
