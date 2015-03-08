package nl.uva.se.interpreter;

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
import nl.uva.se.interpreter.value.BooleanValue;
import nl.uva.se.interpreter.value.DecimalValue;
import nl.uva.se.interpreter.value.IntegerValue;
import nl.uva.se.interpreter.value.StringValue;
import nl.uva.se.interpreter.value.Value;
import nl.uva.se.visitor.ExpressionVisitor;
import nl.uva.se.visitor.FormVisitor;
import nl.uva.se.visitor.StatementVisitor;

public class Evaluator implements FormVisitor, StatementVisitor, ExpressionVisitor<Value> {

	private ValueTable values;
	
	private Evaluator() {
		values = new ValueTable();
	}
	
	public static ValueTable evaluate(Form form) {
		Evaluator evaluator = new Evaluator();
		form.accept(evaluator);
		
		return evaluator.values;
	}
	
	@Override
	public void visit(Form form) {
		form.visitChildren(this);
	}
	
	@Override
	public void visit(Question question) {
		values.addValue(question.getId(), new BooleanValue(false));
	}

	@Override
	public void visit(CalculatedQuestion calculatedQuestion) {
		Value exprValue = calculatedQuestion.getExpression().accept(this);
		values.addValue(calculatedQuestion.getId(), exprValue);
	}

	@Override
	public void visit(Condition condition) {
		Value condValue = condition.getExpression().accept(this);
		
		if (((BooleanValue) condValue).getValue()) {
			condition.visitChildren(this);
		}
	}

	@Override
	public Value visit(Addition plus) {
		Value left = plus.getLeft().accept(this);
		Value right = plus.getRight().accept(this);
		return left.add(right);
	}

	@Override
	public Value visit(Divide divide) {
		Value left = divide.getLeft().accept(this);
		Value right = divide.getRight().accept(this);
		return left.div(right);
	}

	@Override
	public Value visit(Power power) {
		Value left = power.getLeft().accept(this);
		Value right = power.getRight().accept(this);
		return left.pow(right);
	}

	@Override
	public Value visit(Multiply multiply) {
		Value left = multiply.getLeft().accept(this);
		Value right = multiply.getRight().accept(this);
		return left.mult(right);
	}

	@Override
	public Value visit(Modulo modulo) {
		Value left = modulo.getLeft().accept(this);
		Value right = modulo.getRight().accept(this);
		return left.mod(right);
	}

	@Override
	public Value visit(Negative negative) {
		return negative.accept(this).neg();
	}

	@Override
	public Value visit(Positive positive) {
		return positive.accept(this).pos();
	}

	@Override
	public Value visit(Substraction minus) {
		Value left = minus.getLeft().accept(this);
		Value right = minus.getRight().accept(this);
		return left.sub(right);
	}

	@Override
	public Value visit(Not not) {
		return not.accept(this).not();
	}

	@Override
	public Value visit(NotEqual notEqual) {
		Value left = notEqual.getLeft().accept(this);
		Value right = notEqual.getRight().accept(this);
		return left.notEqual(right);
	}

	@Override
	public Value visit(Or or) {
		Value left = or.getLeft().accept(this);
		Value right = or.getRight().accept(this);
		return left.or(right);
	}

	@Override
	public Value visit(LessThen lessThen) {
		Value left = lessThen.getLeft().accept(this);
		Value right = lessThen.getRight().accept(this);
		return left.lessThen(right);
	}

	@Override
	public Value visit(LessOrEqual lessOrEqual) {
		Value left = lessOrEqual.getLeft().accept(this);
		Value right = lessOrEqual.getRight().accept(this);
		return left.lessOrEqual(right);
	}

	@Override
	public Value visit(GreaterThen greaterThen) {
		Value left = greaterThen.getLeft().accept(this);
		Value right = greaterThen.getRight().accept(this);
		return left.greaterThen(right);
	}

	@Override
	public Value visit(GreaterOrEqual greaterOrEqual) {
		Value left = greaterOrEqual.getLeft().accept(this);
		Value right = greaterOrEqual.getRight().accept(this);
		return left.greaterOrEqual(right);
	}

	@Override
	public Value visit(Equal equal) {
		Value left = equal.getLeft().accept(this);
		Value right = equal.getRight().accept(this);
		return left.equal(right);
	}

	@Override
	public Value visit(And and) {
		Value left = and.getLeft().accept(this);
		Value right = and.getRight().accept(this);
		return left.and(right);
	}

	@Override
	public Value visit(BooleanLiteral booleanLiteral) {
		return new BooleanValue(booleanLiteral.getValue());
	}

	@Override
	public Value visit(DecimalLiteral decimalLiteral) {
		return new DecimalValue(decimalLiteral.getValue());
	}

	@Override
	public Value visit(IntegerLiteral integerLiteral) {
		return new IntegerValue(integerLiteral.getValue());
	}

	@Override
	public Value visit(StringLiteral stringLiteral) {
		return new StringValue(stringLiteral.getValue());
	}

	@Override
	public Value visit(Reference reference) {
		return values.getValue(reference.getName());
	}

}
