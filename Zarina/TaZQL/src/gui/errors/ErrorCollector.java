package gui.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
	private final List<TaZQLError> errorCollection;
	private final List<TaZQLWarning> warningCollection;
	
	public ErrorCollector() {
		errorCollection = new ArrayList<TaZQLError>();
		warningCollection = new ArrayList<TaZQLWarning>();
	}
	
	public List<TaZQLError> getErrorCollection() {
		return this.errorCollection;
	}
	
	public List<TaZQLWarning> getWarningCollection() {
		return this.warningCollection;
	}
	
	public void addError(String errorMessage) {
		this.errorCollection.add(new TaZQLError(errorMessage));
	}
	
	public void addWarning(String warningMessage) {
		this.warningCollection.add(new TaZQLWarning(warningMessage));
	}
	
	public boolean containsError() {
		return !this.errorCollection.isEmpty() || !this.warningCollection.isEmpty();
	}
	
	public String toString() {
		String output = "";
		for(TaZQLError error : errorCollection) {
			output += error.getMessage().toString();
		}
		output += " \n";
		for(TaZQLWarning warn : warningCollection) {
			output += warn.getMessage().toString();
		}
		output += " \n";
		
		return output;
	}
}

