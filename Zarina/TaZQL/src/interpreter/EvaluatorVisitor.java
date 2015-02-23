package interpreter;

import java.util.HashMap;
import java.util.Map;

import ast.expression.BracketsExpression;
import ast.expression.IExpressionVisitor;
import ast.expression.arithmetic.AdditionExpression;
import ast.expression.arithmetic.DivisionExpression;
import ast.expression.arithmetic.MultiplicationExpression;
import ast.expression.arithmetic.SubstractionExpression;
import ast.expression.comparison.EqualExpression;
import ast.expression.comparison.GreaterEqualExpression;
import ast.expression.comparison.GreaterThanExpression;
import ast.expression.comparison.LessEqualExpression;
import ast.expression.comparison.LessThanExpression;
import ast.expression.comparison.NotEqualExpression;
import ast.expression.logical.AndExpression;
import ast.expression.logical.OrExpression;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;
import ast.unary.MinusExpression;
import ast.unary.NotExpression;
import ast.unary.PlusExpression;

public class EvaluatorVisitor implements IExpressionVisitor<Value> {

	private final Map<Id, Value> valueStorage = new HashMap<Id, Value>(); 
	
	@Override
	public Value visit(BracketsExpression expr) {
		// TODO Get rid of this...
		return null;
	}

	@Override
	public Value visit(MultiplicationExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.multiply(right);
	}

	@Override
	public Value visit(DivisionExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.divide(right);
	}

	@Override
	public Value visit(AdditionExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.add(right);
	}

	@Override
	public Value visit(SubstractionExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.substract(right);
	}

	@Override
	public Value visit(EqualExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.equality(right);
	}

	@Override
	public Value visit(NotEqualExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.notEqual(right);
	}

	@Override
	public Value visit(LessThanExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.less(right);
	}

	@Override
	public Value visit(GreaterThanExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.greater(right);
	}

	@Override
	public Value visit(LessEqualExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.lessEqual(right);
	}

	@Override
	public Value visit(GreaterEqualExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.greaterEqual(right);
	}

	@Override
	public Value visit(NotExpression expr) {
		Value value = expr.getUnaryExpression().accept(this);
		
		return value.not();
	}

	@Override
	public Value visit(PlusExpression expr) {
		Value value = expr.getUnaryExpression().accept(this);
		
		return value.plus();
	
	}

	@Override
	public Value visit(MinusExpression expr) {
		Value value = expr.getUnaryExpression().accept(this);
		
		return value.minus();
	
	}

	@Override
	public Value visit(AndExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.and(right);
	}

	@Override
	public Value visit(OrExpression expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.or(right);
	}

	@Override
	public Value visit(StringVariable string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(IntegerVariable integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(BooleanVariable bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Id identifier) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
