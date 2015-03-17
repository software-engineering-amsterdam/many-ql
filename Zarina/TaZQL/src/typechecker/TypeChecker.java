package typechecker;

import gui.errors.ErrorDialog;
import ast.form.Form;


public class TypeChecker {
	private final TypeCheckerVisitor typeCheckerVisitor;
	
	public TypeChecker() {
		this.typeCheckerVisitor = new TypeCheckerVisitor();
	}
	
	public boolean isCorrect() {
		return this.typeCheckerVisitor.isCorrect();
	}
	
	public boolean checkQuestionnaire(Form form) {
		form.accept(typeCheckerVisitor);
		return this.typeCheckerVisitor.isCorrect();
	}
	
	public void showErrors() {
		new ErrorDialog(this.typeCheckerVisitor.getError(), this.typeCheckerVisitor.getWarning());
	}
	
	
}
