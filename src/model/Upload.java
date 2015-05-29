package model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Upload {
	
	public String makeFileName(){
		Date now = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss.SS");
		date.format(now);
		return date.toString();
	}
	
}
