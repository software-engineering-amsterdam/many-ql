package ql.errorhandling;

import java.util.ArrayList;
import java.util.List;

public class ErrorEnvironment {
	private List<Error> errors;
	
	public ErrorEnvironment() {
		errors = new ArrayList<Error>();
	}
	
	public boolean hasErrors() {
		return errors.isEmpty();
	}
	
	public void addError(Error error) {
		errors.add(error);
	}	
	
	public void outputErrors() {
		for (Error error : errors) {
			System.out.println(error.getMessage());
		}
	}
	
	public String getErrors() {
		StringBuilder errorString = new StringBuilder();
		
		for (Error error : errors) {
			errorString.append(error.getMessage() + "\n");
		}
		return errorString.toString();
	}
}
