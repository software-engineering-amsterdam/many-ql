package gui.errors;

public class TroublesBase {
	private final String message;
	
	public TroublesBase(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return message;
	}
}