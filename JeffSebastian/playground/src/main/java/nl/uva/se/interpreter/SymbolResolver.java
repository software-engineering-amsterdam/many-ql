package nl.uva.se.interpreter;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class SymbolResolver implements FormVisitor, StatementVisitor {

	private SymbolTable symbols;
	
	private SymbolResolver() {
		symbols = new SymbolTable();
	}
	
	public static SymbolTable resolve(Form form) {
		SymbolResolver visitor = new SymbolResolver();
		visitor.visit(form);
		
		return visitor.symbols;
	}
	
	@Override
	public void visit(Form form) {
		form.visitChildren(this);
	}
	
	@Override
	public void visit(Question question) {
		symbols.addSymbol(question.getId(), question.getType());
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		symbols.addSymbol(calculatedQuestion.getId(),
				calculatedQuestion.getType());
	}

	@Override
	public void visit(Condition condition) {
		condition.visitChildren(this);
	}

}
