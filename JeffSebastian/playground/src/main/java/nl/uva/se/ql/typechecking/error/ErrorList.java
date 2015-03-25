package nl.uva.se.ql.typechecking.error;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ErrorList {
	
	private List<Error> errors;
	private List<Warning> warnings;
	
	public ErrorList() {
		errors = new ArrayList<Error>();
		warnings = new ArrayList<Warning>();
	}
	
	public void addError(Error error) {
		errors.add(error);
	}
	
	public void addWarning(Warning warning) {
		warnings.add(warning);
	}
	
	public boolean hasErrors() {
		return errors.size() != 0;
	}
	
	public void printAll() {
		for (Warning warning : warnings) {
			System.out.println(warning);
		}
		
		for (Error error : errors) {
			System.out.println(error);
		}
	}
	
	public Iterator<Error> getErrors() {
		return errors.iterator();
	}
	
	public Iterator<Warning> getWarnings() {
		return warnings.iterator();
	}

}
