package nl.uva.se.ql.typechecking;

import nl.uva.se.ql.ast.expression.variable.Reference;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.type.Type;
import nl.uva.se.ql.typechecking.error.DuplicateLabels;
import nl.uva.se.ql.typechecking.error.ErrorList;
import nl.uva.se.ql.typechecking.error.IncompatibleTypeDeclaration;
import nl.uva.se.ql.typechecking.error.UndefinedReference;

public class SymbolResolver extends AbstractResolver {

	private SymbolTable symbols;
	private ErrorList errors;

	private SymbolResolver() {
		symbols = new SymbolTable();
		errors = new ErrorList();
	}

	public static SymbolResult resolve(Form form) {
		SymbolResolver visitor = new SymbolResolver();
		visitor.visit(form);

		return new SymbolResult(visitor.errors, visitor.symbols);
	}

	@Override
	public void visit(Question question) {
		addSymbol(question);		
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		addSymbol(calculatedQuestion);
		calculatedQuestion.getExpression().accept(this);
	}

	@Override
	public Void visit(Reference reference) {
		if (!symbols.containsSymbol(reference.getName())) {
			errors.addError(new UndefinedReference(reference.getLineNumber(), 
					reference.getOffset(), reference.getName()));
		}
		
		return null;
	}
	
	private void addSymbol(Question question) {
		if (symbols.containsSymbol(question.getId())) {
			Type existingType = symbols.getTypeForSymbol(question.getId());
			if (existingType.equals(question.getType())) {
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
