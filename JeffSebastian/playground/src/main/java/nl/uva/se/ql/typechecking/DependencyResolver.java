package nl.uva.se.ql.typechecking;

import nl.uva.se.ql.ast.expression.variable.Reference;
import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Question;

public class DependencyResolver extends AbstractResolver {

	private DependencyTable dependencies;
	private SymbolTable symbols;
	private Question currentContext;

	private DependencyResolver(SymbolTable symbols) {
		dependencies = new DependencyTable();
		this.symbols = symbols;
	}

	public static DependencyTable resolve(Form form, SymbolTable symbols) {
		DependencyResolver resolver = new DependencyResolver(symbols);
		form.accept(resolver);

		return resolver.dependencies;
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		currentContext = calculatedQuestion;
		calculatedQuestion.getExpression().accept(this);
		currentContext = null;
	}

	@Override
	public Void visit(Reference reference) {
		dependencies.addDependency(currentContext,
				symbols.getQuestionForSymbol(reference.getName()));
		return null;
	}

}
