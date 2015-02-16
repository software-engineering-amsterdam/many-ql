package cons.exception;

public class UndefinedVariableException extends Exception {
	private static final long serialVersionUID = 3355369452354265920L;

	public UndefinedVariableException() {}

      public UndefinedVariableException(String message) {
         super(message);
      }	 
}
