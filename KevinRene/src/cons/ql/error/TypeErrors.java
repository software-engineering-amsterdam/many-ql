package cons.ql.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.statement.Question;


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
	
	public void incompatibleType(ASTNode node,
			QLType expectedType, QLType actualType) {
		errors.add(new Error(node, "Expected " + expectedType + ", got " 
				+ actualType + "."));
	}
	
	public void incompatibleTypes(ASTNode node, 
			List<QLType> operandTypes, QLType compatibleTo) {		
		// Create string of actual types
		String actualTypes = operandTypes
				.stream()
				.map(x -> x.toString())
				.collect(Collectors.joining(" & "));
		
		errors.add(new Error(node, "Expected type: " 
				+ compatibleTo.compatibilities() + ", actual types: " 
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
}
