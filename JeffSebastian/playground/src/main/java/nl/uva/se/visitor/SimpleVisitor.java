package nl.uva.se.visitor;

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

public class SimpleVisitor implements FormVisitor, StatementVisitor, ExpressionVisitor<Void> {

	@Override
	public void visit(Form form) {
		System.out.println(form.getId());
		form.visitChildren(this);
	}

	@Override
	public void visit(Question question) {
		System.out.println(question.getQuestion());
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		System.out.println(calculatedQuestion.getQuestion());
		calculatedQuestion.getExpression().accept(this);
	}

	@Override
	public void visit(Condition condition) {
		condition.getExpression().accept(this);
		condition.visitChildren(this);
	}

	@Override
	public Void visit(Not not) {
		return null;
	}

	@Override
	public Void visit(NotEqual notEqual) {
		return null;
	}

	@Override
	public Void visit(Or or) {
		return null;
	}

	@Override
	public Void visit(Addition plus) {
		return null;
	}

	@Override
	public Void visit(Power power) {
		return null;
	}

	@Override
	public Void visit(Multiply multiply) {
		return null;
	}

	@Override
	public Void visit(Modulo modulo) {
		return null;
	}

	@Override
	public Void visit(Substraction minus) {
		System.out.print("(");
		minus.getLeft().accept(this);
		System.out.print("-");
		minus.getRight().accept(this);
		System.out.print(")");
		return null;
	}

	@Override
	public Void visit(LessThen lessThen) {
		return null;
	}

	@Override
	public Void visit(LessOrEqual lessOrEqual) {
		return null;
	}

	@Override
	public Void visit(GreaterThen greaterThen) {
		return null;
	}

	@Override
	public Void visit(GreaterOrEqual greaterOrEqual) {
		return null;
	}

	@Override
	public Void visit(Equal equal) {
		return null;
	}

	@Override
	public Void visit(Divide divide) {
		return null;
	}

	@Override
	public Void visit(And and) {
		return null;
	}

	@Override
	public Void visit(BooleanLiteral booleanLiteral) {
		System.out.println("Boolean: " + booleanLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(DecimalLiteral decimalLiteral) {
		System.out.println("Decimal: " + decimalLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(IntegerLiteral integerLiteral) {
		System.out.print(integerLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(StringLiteral stringLiteral) {
		System.out.println("String: " + stringLiteral.getValue());
		return null;
	}

	@Override
	public Void visit(Negative negative) {
		return null;
	}

	@Override
	public Void visit(Positive positive) {
		return null;
	}

	@Override
	public Void visit(Reference reference) {
		System.out.println("Reference: " + reference.getName());
		return null;
	}

}
