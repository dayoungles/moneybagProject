package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private final String DEFAULT = "default.png";
	private final int ZERO = 0;
	private final int IMAGE_LENGTH = 6; //string "image/"를 잘라내기 위한 고정사이즈  
	
	private MultipartFile multipartFile;
	private String nameOfmf;
	
	public FileUpload(){
		
	}
	public FileUpload(MultipartFile file2) {
		this.multipartFile = file2;
		isFileExist(file2);
	}
	
	private void isFileExist(MultipartFile file2) {
		if(file2.isEmpty()){
			this.nameOfmf = DEFAULT;
		}else {
			setName();
		}
	}
	
	public MultipartFile getFile() {
		return multipartFile;
	}

	public void setFile(MultipartFile file) {
		this.multipartFile = file;
	}

	public String getName() {
		return nameOfmf;
	}
	
	/**
	 * 파일 이름 중복 제거를 위해 파일 업로드 시각 으로 파일 이름을 다시 지정한다. 
	 */
	public void setName() {
		Date now = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd_HH:mm:ss:SSS");
		date.format(now);
		String contentType = this.multipartFile.getContentType();
		contentType = contentType.substring(IMAGE_LENGTH, contentType.length());
		this.nameOfmf= date.format(now) +"."+ contentType;
	}
	
	@Override
	public String toString() {
		return "FileUpload [multipartFile=" + multipartFile + ", nameOfmf="
				+ nameOfmf + "]";
	}

}
