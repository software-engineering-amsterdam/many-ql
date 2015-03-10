package nl.uva.se.ql.typechecking;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.interpretation.Result;
import nl.uva.se.ql.interpretation.error.DuplicateLabels;
import nl.uva.se.ql.interpretation.error.ErrorList;
import nl.uva.se.ql.interpretation.error.IncompatibleTypeDeclaration;

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

	public void visit(Form form) {
		form.visitChildren(this);
	}

	public void visit(Question question) {
		addSymbol(question);		
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		addSymbol(calculatedQuestion);		
	}

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
