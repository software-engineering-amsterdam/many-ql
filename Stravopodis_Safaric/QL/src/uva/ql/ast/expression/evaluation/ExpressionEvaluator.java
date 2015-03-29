package uva.ql.ast.expression.evaluation;

import uva.ql.ast.expressions.BinaryExpression;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.IntLiteral;
import uva.ql.ast.expressions.literals.MoneyLiteral;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.expressions.logic.And;
import uva.ql.ast.expressions.logic.Equal;
import uva.ql.ast.expressions.logic.Greater;
import uva.ql.ast.expressions.logic.Greater_Eq;
import uva.ql.ast.expressions.logic.Less;
import uva.ql.ast.expressions.logic.Less_Eq;
import uva.ql.ast.expressions.logic.NotEqual;
import uva.ql.ast.expressions.logic.Or;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.expressions.math.Division;
import uva.ql.ast.expressions.math.Exponentiation;
import uva.ql.ast.expressions.math.Multiplication;
import uva.ql.ast.expressions.math.Substraction;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class ExpressionEvaluator implements ExpressionVisitor<Object>{
	
	private ValueTable valueTable;
	
	public GenericValue<?> visitExpressionWithValueTable(Expression expression, ValueTable valueTable){
		this.valueTable = valueTable;
		return this.visitExpression(expression);
	}
	
	@Override
	public Expression visitBinaryExpression(BinaryExpression expression) {
		return null;
	}

	@Override
	public GenericValue<?> visitExpression(Expression expression) {
		return (GenericValue<?>)expression.accept(this);
	}

	@Override
	public NumberValue visitExponentiation(Exponentiation exponentiation) {
		NumberValue leftValue = (NumberValue)exponentiation.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)exponentiation.getRightExpr().accept(this);
		
		return leftValue.exponentiation(rightValue);
	}

	@Override
	public NumberValue visitAddition(Addition addition) {
		NumberValue leftValue = (NumberValue)addition.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)addition.getRightExpr().accept(this);
		
		return leftValue.addition(rightValue);
	}

	@Override
	public NumberValue visitSubstraction(Substraction substraction) {
		NumberValue leftValue = (NumberValue)substraction.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)substraction.getRightExpr().accept(this);
		
		return leftValue.substraction(rightValue);
	}

	@Override
	public NumberValue visitMultiplication(Multiplication multipllication) {
		NumberValue leftValue = (NumberValue)multipllication.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)multipllication.getRightExpr().accept(this);
		
		return leftValue.multiplication(rightValue);	
	}

	@Override
	public NumberValue visitDivision(Division division) {
		NumberValue leftValue = (NumberValue)division.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)division.getRightExpr().accept(this);
		
		return leftValue.division(rightValue);	
	}

	@Override
	public BooleanValue visitAnd(And and) {
		BooleanValue leftValue = (BooleanValue)and.getLeftExpr().accept(this);
		BooleanValue rightValue = (BooleanValue)and.getRightExpr().accept(this);
		
		return leftValue.and(rightValue);
	}

	@Override
	public BooleanValue visitOr(Or or) {
		BooleanValue leftValue = (BooleanValue)or.getLeftExpr().accept(this);
		BooleanValue rightValue = (BooleanValue)or.getRightExpr().accept(this);
		
		return leftValue.or(rightValue);
	}

	@Override
	public BooleanValue visitEqual(Equal equal) {
		GenericValue<?> leftValue = (GenericValue<?>)equal.getLeftExpr().accept(this);
		GenericValue<?> rightValue = (GenericValue<?>)equal.getRightExpr().accept(this);
		
		return new BooleanValue(leftValue.equalsTo(rightValue));
	}

	@Override
	public BooleanValue visitNotEqual(NotEqual notEqual) {
		GenericValue<?> leftValue = (GenericValue<?>)notEqual.getLeftExpr().accept(this);
		GenericValue<?> rightValue = (GenericValue<?>)notEqual.getRightExpr().accept(this);
		
		return new BooleanValue(leftValue.equalsTo(rightValue));
	}

	@Override
	public BooleanValue visitGreaterEqual(Greater_Eq greaterEqual) {
		NumberValue leftValue = (NumberValue)greaterEqual.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)greaterEqual.getRightExpr().accept(this);
		
		return leftValue.greaterEqual(rightValue);
	}

	@Override
	public BooleanValue visitGreater(Greater greater) {
		NumberValue leftValue = (NumberValue)greater.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)greater.getRightExpr().accept(this);
		
		return leftValue.greater(rightValue);
	}

	@Override
	public BooleanValue visitLessEqual(Less_Eq lessEqual) {
		NumberValue leftValue = (NumberValue)lessEqual.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)lessEqual.getRightExpr().accept(this);
		
		return leftValue.lessEqual(rightValue);
	}

	@Override
	public BooleanValue visitLess(Less less) {
		NumberValue leftValue = (NumberValue)less.getLeftExpr().accept(this);
		NumberValue rightValue = (NumberValue)less.getRightExpr().accept(this);
		
		return leftValue.less(rightValue);
	}

	@Override
	public GenericValue<?> visitIdentifier(Identifier identifier) {
		return identifier.getValueFromValueTable(this.valueTable);
	}

	@Override
	public BooleanValue visitBooleanLiteral(BooleanLiteral booleanLiteral) {
		return booleanLiteral.evaluate();
	}

	@Override
	public NumberValue visitMoneyLiteral(MoneyLiteral moneyLiteral) {
		return moneyLiteral.evaluate();
	}

	@Override
	public NumberValue visitIntLiteral(IntLiteral intLiteral) {
		return intLiteral.evaluate();
	}

	@Override
	public StringValue visitStringLiteral(StringLiteral stringLiteral) {
		return stringLiteral.evaluate();
	}
}
