package typechecker.errors;

public class TaZQLError {
	private final String errorMessage;
	
	public TaZQLError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
}
