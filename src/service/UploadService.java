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
	private static String path;

	private static final Logger logger = LoggerFactory.getLogger(UploadService.class);

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
	public FileUpload uploadFile(MultipartFile mfile, String filePos, ServletContext sc) throws Exception {
		this.path = (String) sc.getAttribute("realPath");
		logger.debug("path:{}", this.path);
		if (isImgFile(mfile) == false) {
			throw new Exception("not img file");// exception 발생 시키라는데..익셉션을 피해갈 방법은 정녕 없는 것인가
		}
		

		// file을 업로드 하려고 하는 폴더가 없으면 만들어준다.
		File folder = new File(filePos);
		if (!folder.exists()) {
			folder.mkdir();
		}
		FileUpload upload = new FileUpload(mfile);
		File file = new File(path + filePos+ upload.getName());
		
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
