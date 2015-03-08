package nl.uva.se.typechecking;

import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.interpretation.Result;
import nl.uva.se.interpretation.error.ErrorList;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class DependencyResolver implements FormVisitor, StatementVisitor {

	private DependencyTable dependencies;
	
	private ErrorList errors;
	
	private DependencyResolver() {
		dependencies = new DependencyTable();
		errors = new ErrorList();
	}
	
	public static Result<DependencyTable> resolve(Form form) {
		DependencyResolver resolver = new DependencyResolver();
		form.accept(resolver);
		
		return new Result<DependencyTable>(resolver.errors, resolver.dependencies);
	}

	@Override
	public void visit(Form form) {
		form.visitChildren(this);
	}

	@Override
	public void visit(Question question) {
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		calculatedQuestion.getExpression();
		
	}

	@Override
	public void visit(Condition condition) {
	}
}
