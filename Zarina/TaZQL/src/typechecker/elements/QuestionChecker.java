package typechecker.elements;

import typechecker.TypeRepository;
import typechecker.errors.ErrorCollector;
import ast.type.Type;

public class QuestionChecker {
	private final String id, label;
	private final Type type;
	private final ErrorCollector errorCollector;
	private final TypeRepository typeRepository;
	
	public QuestionChecker(String id, String label, Type type, ErrorCollector errorCollector, TypeRepository typeRepository) {
		this.id = id;
		this.label = label;
		this.type = type;
		this.errorCollector = errorCollector;
		this.typeRepository = typeRepository;
	}

	public ErrorCollector getErrors() {
		return this.errorCollector;
	}
	
	// duplicate question declarations with different types
	public void checkDuplicateDeclaration() {
	  if(!this.typeRepository.empty()) {
		if (!this.typeRepository.isDeclared(id) || this.typeRepository.getValue(id).equals(type)) {
			return;
		}
		
		this.errorCollector.addError("Question declaration *" + id + "* is duplicated. "
									+ "It is used with a different type.");
	  }
	}
	
	//duplicate labels (warning)
	public void checkDuplicateLabels() {
		//TODO
		this.errorCollector.addWarning("Testing my warning");
	}
}
