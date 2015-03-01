package org.uva.ql.typecheck;

import java.util.ArrayList;

import org.uva.ql.typecheck.message.Warning;

public class MessageManager {
	
	private final ArrayList<Error> errors;
	private final ArrayList<Warning> warnings;
	
	public MessageManager() {
		errors = new ArrayList<Error>();
		warnings = new ArrayList<Warning>();
	}
	
	public void addError(Error error) {
		errors.add(error);
	}
	
	public void addWarning(Warning warning) {
		warnings.add(warning);
	}
	
	public int countErrors() {
		return errors.size();
	}
	
	public int countWarnings() {
		return warnings.size();
	}
	
	public void printErrors() {
		for (Error error : errors) {
			System.out.println(error);
		}
	}
	
	public void printWarnings() {
		for (Warning warning : warnings) {
			System.out.println(warning);
		}
	}
}
