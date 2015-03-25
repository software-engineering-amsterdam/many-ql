package evaluator;

import ast.expression.Brackets;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.expression.arithmetic.Addition;
import ast.expression.arithmetic.Division;
import ast.expression.arithmetic.Multiplication;
import ast.expression.arithmetic.Substraction;
import ast.expression.comparison.Equal;
import ast.expression.comparison.GreaterEqual;
import ast.expression.comparison.GreaterThan;
import ast.expression.comparison.LessEqual;
import ast.expression.comparison.LessThan;
import ast.expression.comparison.NotEqual;
import ast.expression.logical.And;
import ast.expression.logical.Or;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;
import ast.unary.Minus;
import ast.unary.Not;
import ast.unary.Plus;

public class EvaluatorVisitor implements IExpressionVisitor<Value> {

	private final ValueRepository valueRepository;
	
	public EvaluatorVisitor(ValueRepository valueRepository) {
		this.valueRepository = valueRepository;
	}
	
	@Override
	public Value visit(Multiplication expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.multiply(right);
	}

	@Override
	public Value visit(Division expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.divide(right);
	}

	@Override
	public Value visit(Addition expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.add(right);
	}

	@Override
	public Value visit(Substraction expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.substract(right);
	}

	@Override
	public Value visit(Equal expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.equality(right);
	}

	@Override
	public Value visit(NotEqual expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.notEqual(right);
	}

	@Override
	public Value visit(LessThan expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.less(right);
	}

	@Override
	public Value visit(GreaterThan expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.greater(right);
	}

	@Override
	public Value visit(LessEqual expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.lessEqual(right);
	}

	@Override
	public Value visit(GreaterEqual expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.greaterEqual(right);
	}

	@Override
	public Value visit(Not expr) {
		Value value = expr.getUnaryExpression().accept(this);
		
		return value.not();
	}

	@Override
	public Value visit(Plus expr) {
		Value value = expr.getUnaryExpression().accept(this);
		
		return value.plus();
	
	}

	@Override
	public Value visit(Minus expr) {
		Value value = expr.getUnaryExpression().accept(this);
		
		return value.minus();
	
	}

	@Override
	public Value visit(And expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.and(right);
	}

	@Override
	public Value visit(Or expr) {
		Value left = expr.getLeftExpression().accept(this);
		Value right = expr.getRightExpression().accept(this);
		
		return left.or(right);
	}

	@Override
	public Value visit(Brackets expr) {
		return expr.getBracketsExpression().accept(this);
	}
	
	@Override
	public Value visit(StringVariable string) {
		return new StringValue(string.getVariable());
	}

	@Override
	public Value visit(IntegerVariable integer) {
		return new IntegerValue(integer.getVariable());
	}

	@Override
	public Value visit(BooleanVariable bool) {
		return new BooleanValue(bool.getVariable());
	}
	
	@Override
	public Value visit(Id identifier) {
		return valueRepository.getValue(identifier.getID());
	}	
}
