package typechecker;

import gui.errors.ErrorDialog;
import gui.errors.TaZQLError;
import gui.errors.TaZQLWarning;

import java.util.List;

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
		return isCorrect();
	}
	
	public void showErrors() {
		new ErrorDialog(getError(), getWarning());
	}
	
	public List<TaZQLError> getError() {
		return this.typeCheckerVisitor.getError();
	}
	
	public List<TaZQLWarning> getWarning() {
		return this.typeCheckerVisitor.getWarning();
	}
	
}
