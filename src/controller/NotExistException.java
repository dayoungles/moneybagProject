package controller;

public class NotExistException extends Exception{
	public NotExistException(){
		super();
	}
	
	public NotExistException(String msg){
		super(msg);
	}
}
