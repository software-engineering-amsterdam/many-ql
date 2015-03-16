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
		return errorCollection;
	}
	
	public List<TaZQLWarning> getWarningCollection() {
		return warningCollection;
	}
	
	public void addError(String errorMessage) {
		errorCollection.add(new TaZQLError(errorMessage));
	}
	
	public void addWarning(String warningMessage) {
		warningCollection.add(new TaZQLWarning(warningMessage));
	}
	
	public boolean containsError() {
		return !this.errorCollection.isEmpty();
	}
	
	public boolean containsWarning() {
		return !this.warningCollection.isEmpty();
	}
	
	public String toString() {
		String output = "";
		for(TaZQLError error : errorCollection) {
			output += error.getErrorMessage().toString();
		}
		output += " \n";
		for(TaZQLWarning warn : warningCollection) {
			output += warn.getWarningMessage().toString();
		}
		output += " \n";
		
		return output;
	}
}

