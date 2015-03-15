package ql.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ql.ast.QLNode;
import ql.ast.QLType;
import ql.ast.expression.Identifier;
import ql.ast.statement.Question;


public class TypeErrors {
	private List<Error> errors;
	
	public TypeErrors() {
		errors = new ArrayList<Error>();
	}
	
	public boolean hasErrors() {
		return errors.isEmpty();
	}
	
	public void undefinedVariable(Identifier identifier) {
		errors.add(new Error(identifier, identifier + " was used before being defined."));
	}
	
	public void doubleDefinedVariable(Identifier identifier) {
		errors.add(new Error(identifier, identifier + " is defined multiple times."));
	}
	
	public void incompatibleType(QLNode node,
			QLType expectedType, QLType actualType) {
		errors.add(new Error(node, "Expected " + expectedType + ", got " 
				+ actualType + "."));
	}
	
	public void incompatibleTypes(QLNode node, 
			List<QLType> operandTypes, QLType compatibleTo) {		
		// Create string of actual types
		String actualTypes = operandTypes
				.stream()
				.map(x -> x.toString())
				.collect(Collectors.joining(" & "));
		
		errors.add(new Error(node, "Expected type: " 
				+ compatibleTo.compatibilitiesAsStrings() + ", actual types: " 
				+ actualTypes	+ "."));
	}
	
	public void illegalQuestionAssignment(Question question, 
			QLType expectedType, QLType actualType) {
		errors.add(new Error(question, question.getIdentifier() + ":" 
				+ expectedType + " was assigned a "
				+ actualType + "."));
	}
	
	public void outputErrors() {
		for (Error error : errors) {
			System.out.println("[Error]: " 
					+ "<" + error.getErrorOriginClass() + "> "
					+ error.getErrorMessage());
		}
	}
	
	public String getErrors() {
		StringBuilder errorString = new StringBuilder();
		
		for (Error error : errors) {
			errorString.append("[Error]: " 
					+ "<" + error.getErrorOriginClass() + "> "
					+ error.getErrorMessage() + "\n");
		}
		return errorString.toString();
	}
}
