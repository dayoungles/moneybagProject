package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private static final String DEFAULT = "default.png";
	private static final int ZERO = 0;
	
	private MultipartFile multipartFile;
	private String nameOfmf;
	private String fileType;
	
	public FileUpload(){
		
	}
	public FileUpload(MultipartFile file2) {
		this.multipartFile = file2;
		this.fileType = file2.getContentType();
		if(file2.getSize() == 0){
			this.nameOfmf = DEFAULT;
		}else {
			setName();
		}
		
	}
	
	private boolean checkFileType(){
		String type = this.multipartFile.getContentType();
		if(type!= "jpg"|| type!="jpeg" || type!="png"|| type !="bmp"){
			return false;
		}
		return true;
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
	 * 파일 이름 중복 제거를 위해 파일 업로드 시각+ user name 으로 파일 이름을 다시 지정한다. 
	 */
	public void setName() {
		Date now = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yy-MM-dd_hh:mm:ss.SSS");
		date.format(now);
		this.nameOfmf= date.format(now);
	}
	
	@Override
	public String toString() {
		return "FileUpload [multipartFile=" + multipartFile + ", nameOfmf="
				+ nameOfmf + "]";
	}

}
