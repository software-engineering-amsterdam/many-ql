package uva.ql.interpreter.typecheck.exception;

public class IllegalTypeException extends RuntimeException{
	
	private final static long serialVersionUID = 477189107700903771L;
	
	public IllegalTypeException(String message){
		super(message);
	}
	public IllegalTypeException(String message, Throwable throwable){
		super(message, throwable);
	}
}
