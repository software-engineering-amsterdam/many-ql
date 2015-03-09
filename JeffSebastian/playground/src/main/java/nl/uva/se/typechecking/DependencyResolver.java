package nl.uva.se.typechecking;

import java.util.Set;

import nl.uva.se.ast.expression.Binary;
import nl.uva.se.ast.expression.Unary;
import nl.uva.se.ast.expression.arithmetical.Addition;
import nl.uva.se.ast.expression.arithmetical.Divide;
import nl.uva.se.ast.expression.arithmetical.Modulo;
import nl.uva.se.ast.expression.arithmetical.Multiply;
import nl.uva.se.ast.expression.arithmetical.Negative;
import nl.uva.se.ast.expression.arithmetical.Positive;
import nl.uva.se.ast.expression.arithmetical.Power;
import nl.uva.se.ast.expression.arithmetical.Substraction;
import nl.uva.se.ast.expression.literal.BooleanLiteral;
import nl.uva.se.ast.expression.literal.DecimalLiteral;
import nl.uva.se.ast.expression.literal.IntegerLiteral;
import nl.uva.se.ast.expression.literal.StringLiteral;
import nl.uva.se.ast.expression.logical.And;
import nl.uva.se.ast.expression.logical.Equal;
import nl.uva.se.ast.expression.logical.GreaterOrEqual;
import nl.uva.se.ast.expression.logical.GreaterThen;
import nl.uva.se.ast.expression.logical.LessOrEqual;
import nl.uva.se.ast.expression.logical.LessThen;
import nl.uva.se.ast.expression.logical.Not;
import nl.uva.se.ast.expression.logical.NotEqual;
import nl.uva.se.ast.expression.logical.Or;
import nl.uva.se.ast.expression.variable.Reference;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.interpretation.Result;
import nl.uva.se.interpretation.error.CyclicDependency;
import nl.uva.se.interpretation.error.ErrorList;
import nl.uva.se.visitor.ExpressionVisitor;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class DependencyResolver implements FormVisitor, StatementVisitor, ExpressionVisitor<Void> {

	private DependencyTable dependencies;
	private ErrorList errors;
	private Question currentContext;
	
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
		currentContext = calculatedQuestion;
		calculatedQuestion.getExpression().accept(this);
		checkDependenciesFor(calculatedQuestion);
		currentContext = null;
	}

	@Override
	public void visit(Condition condition) {
		condition.visitChildren(this);
	}

	@Override
	public Void visit(Addition plus) {
		visitBinaryExpression(plus);
		return null;
	}

	@Override
	public Void visit(Divide divide) {
		visitBinaryExpression(divide);
		return null;
	}

	@Override
	public Void visit(Power power) {
		visitBinaryExpression(power);
		return null;
	}

	@Override
	public Void visit(Multiply multiply) {
		visitBinaryExpression(multiply);
		return null;
	}

	@Override
	public Void visit(Modulo modulo) {
		visitBinaryExpression(modulo);
		return null;
	}

	@Override
	public Void visit(Negative negative) {
		visitUnaryExpression(negative);
		return null;
	}

	@Override
	public Void visit(Positive positive) {
		visitUnaryExpression(positive);
		return null;
	}

	@Override
	public Void visit(Substraction minus) {
		visitBinaryExpression(minus);
		return null;
	}

	@Override
	public Void visit(Not not) {
		visitUnaryExpression(not);
		return null;
	}

	@Override
	public Void visit(NotEqual notEqual) {
		visitBinaryExpression(notEqual);
		return null;
	}

	@Override
	public Void visit(Or or) {
		visitBinaryExpression(or);
		return null;
	}

	@Override
	public Void visit(LessThen lessThen) {
		visitBinaryExpression(lessThen);
		return null;
	}

	@Override
	public Void visit(LessOrEqual lessOrEqual) {
		visitBinaryExpression(lessOrEqual);
		return null;
	}

	@Override
	public Void visit(GreaterThen greaterThen) {
		visitBinaryExpression(greaterThen);
		return null;
	}

	@Override
	public Void visit(GreaterOrEqual greaterOrEqual) {
		visitBinaryExpression(greaterOrEqual);
		return null;
	}

	@Override
	public Void visit(Equal equal) {
		visitBinaryExpression(equal);
		return null;
	}

	@Override
	public Void visit(And and) {
		visitBinaryExpression(and);
		return null;
	}

	@Override
	public Void visit(BooleanLiteral booleanLiteral) {
		return null;
	}

	@Override
	public Void visit(DecimalLiteral decimalLiteral) {
		return null;
	}

	@Override
	public Void visit(IntegerLiteral integerLiteral) {
		return null;
	}

	@Override
	public Void visit(StringLiteral stringLiteral) {
		return null;
	}

	@Override
	public Void visit(Reference reference) {
		dependencies.addDependency(currentContext.getId(), reference.getName());
		return null;
	}
	
	private void visitBinaryExpression(Binary expr) {
		expr.getLeft().accept(this);
		expr.getRight().accept(this);
	}
	
	private void visitUnaryExpression(Unary expr) {
		expr.getSingleExpression().accept(this);
	}
	
	/**
	 * Dependency check stops after the first occurance of a cyclic dependency
	 * 
	 * @param question
	 */
	private void checkDependenciesFor(Question question) {
		Set<String> dpc = dependencies.getDependenciesFor(question.getId());
		
		for (String dependant : dpc) {
			if (dependant.equals(question.getId())) {
				errors.addError(new CyclicDependency(question.getLineNumber(), 
						question.getOffset()));
				return;
			}
			checkAllPaths(question, dependencies.getDependenciesFor(dependant));
		}
	}
	
	private void checkAllPaths(Question question, Set<String> dependants) {
		for (String s : dependants) {
			if (s.equals(question.getId())) {
				errors.addError(new CyclicDependency(question.getLineNumber(), 
						question.getOffset()));
				return;
			}
		}
	}
}
