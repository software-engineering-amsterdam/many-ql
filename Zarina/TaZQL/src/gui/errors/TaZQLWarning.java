package gui.errors;

public class TaZQLWarning {
	private final String warningMessage;
	
	public TaZQLWarning(String warningMessage) {
		this.warningMessage = warningMessage;
	}

	public String getWarningMessage() {
		return this.warningMessage;
	}
	
	public String toString() {
		return warningMessage;
	}
}
