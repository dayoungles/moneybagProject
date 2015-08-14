package exception;

import java.lang.Exception;

public class ValidException extends Exception{
	public ValidException(){
		super();
	}
	
	public ValidException(String msg){
		super(msg);
	}
	
}
