package nl.uva.se.interpreter;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.interpreter.error.DuplicateLabels;
import nl.uva.se.interpreter.error.ErrorList;
import nl.uva.se.interpreter.error.IncompatibleTypeDeclaration;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class SymbolResolver implements FormVisitor, StatementVisitor {

	private SymbolTable symbols;
	private ErrorList errors;

	private SymbolResolver() {
		symbols = new SymbolTable();
		errors = new ErrorList();
	}

	public static Result<SymbolTable> resolve(Form form) {
		SymbolResolver visitor = new SymbolResolver();
		visitor.visit(form);

		return new Result<SymbolTable>(visitor.errors, visitor.symbols);
	}

	@Override
	public void visit(Form form) {
		form.visitChildren(this);
	}

	@Override
	public void visit(Question question) {
		addSymbol(question);
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		addSymbol(calculatedQuestion);
	}

	@Override
	public void visit(Condition condition) {
		condition.visitChildren(this);
	}
	
	private void addSymbol(Question question) {
		if (symbols.containsSymbol(question.getId())) {
			if (symbols.getTypeForSymbol(question.getId()).equals(
					question.getType())) {
				errors.addWarning(new DuplicateLabels(question.getLineNumber(),
						question.getOffset(), question.getId()));
			} else {
				errors.addError(new IncompatibleTypeDeclaration(symbols
						.getQuestionForSymbol(question.getId()), question));
			}
		} else {
			symbols.addSymbol(question.getId(), question);
		}
	}

}
