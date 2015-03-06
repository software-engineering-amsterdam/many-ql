package typechecker.errors;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
	private final List<TaZQLError> errorCollection;
	
	public ErrorCollector() {
		errorCollection = new ArrayList<TaZQLError>();
	}
	
	public List<TaZQLError> getErrorCollection() {
		System.out.print(errorCollection);
		return errorCollection;
	}
	
	public void addError(String errorMessage) {
		errorCollection.add(new TaZQLError(errorMessage));
	}
	
	public boolean containsError() {
		return !this.errorCollection.isEmpty();
	}
	
	public void clearErrorCollection() {
		this.errorCollection.clear();
	}
}

