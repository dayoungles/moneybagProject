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
//sample code 
	// private String uploadPath;
	//
	// @Value("${upload.path}")
	// public void setUploadPath(String uploadPath) {
	// this.uploadPath = uploadPath;
	// }

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
	public FileUpload uploadFileToFolder(MultipartFile mfile, String filePos) throws NotImgException {
		checkImgException(mfile);
		checkUploadPathExist(filePos);

		FileUpload preparedFile = new FileUpload(mfile);

		if (preparedFile.isFileExist()) {
			uploadFile(mfile, filePos, preparedFile);
		} 
		return preparedFile;
	}

	private void uploadFile(MultipartFile mfile, String filePos, FileUpload preparedFile) {
		String uploadPath = this.path + filePos + preparedFile.getName();
		File file = new File(uploadPath);

		try {
			mfile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkImgException(MultipartFile mfile) throws NotImgException {
		if (isImgFile(mfile) == false) {
			throw new NotImgException("이미지 파일을 업로드 하세요");
		}
	}

	private void checkUploadPathExist(String filePos) {
		File folder = new File(this.path + filePos);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public boolean isImgFile(MultipartFile file) {
		String contentType = file.getContentType();
		if (contentType.startsWith("image/") || file.isEmpty())
			return true;
		else
			return false;

	}

}
