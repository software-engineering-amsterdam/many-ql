package ast.visitor;

import ast.expression.association.Parenthese;
import ast.expression.binary.And;
import ast.expression.binary.Divide;
import ast.expression.binary.Equal;
import ast.expression.binary.Greater;
import ast.expression.binary.GreaterEqual;
import ast.expression.binary.Less;
import ast.expression.binary.LessEqual;
import ast.expression.binary.Minus;
import ast.expression.binary.Multiply;
import ast.expression.binary.NotEqual;
import ast.expression.binary.Or;
import ast.expression.binary.Plus;
import ast.expression.literal.BoolLiteral;
import ast.expression.literal.Identifier;
import ast.expression.literal.IntLiteral;
import ast.expression.literal.StrLiteral;
import ast.expression.unary.Negative;
import ast.expression.unary.Not;
import ast.expression.unary.Positive;
import ast.value.Bool;
import ast.value.Int;
import ast.value.Str;
import ast.value.Value;

public class Evaluator implements Visitor<Value> {

	public Evaluator() {
		
	}

	@Override
	public Value visit(Not node) {
		return node.getExpression().accept(this).not();
	}
	
	@Override
	public Value visit(Positive node) {
		return node.getExpression().accept(this).positive();
	}
	
	@Override
	public Value visit(Negative node) {
		return node.getExpression().accept(this).negative();
	}
	
	@Override
	public Value visit(Plus node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.plus(right);
	}

	@Override
	public Value visit(Minus node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.minus(right);
	}
	
	@Override
	public Value visit(Multiply node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.multiply(right);
	}
	
	@Override
	public Value visit(Divide node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.divide(right);
	}

	@Override
	public Value visit(And node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.and(right);
	}

	@Override
	public Value visit(Or node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.or(right);
	}

	@Override
	public Value visit(Equal node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.equal(right);
	}

	@Override
	public Value visit(NotEqual node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.notEqual(right);
	}

	@Override
	public Value visit(Greater node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.greater(right);
	}

	@Override
	public Value visit(GreaterEqual node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.greaterEqual(right);
	}

	@Override
	public Value visit(Less node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.less(right);
	}

	@Override
	public Value visit(LessEqual node) {
		Value left = node.getLeftExpression().accept(this);
		Value right = node.getRightExpression().accept(this);
		return left.lessEqual(right);
	}

	@Override
	public Value visit(Identifier node) {
		return null;
	}

	@Override
	public Value visit(IntLiteral node) {
		return new Int(node.getValue());
	}
	
	@Override
	public Value visit(BoolLiteral node) {
		return new Bool(node.getValue());
	}

	@Override
	public Value visit(StrLiteral node) {
		return new Str(node.getValue());
	}

	@Override
	public Value visit(Parenthese node) {
		return node.getExpression().accept(this);
	}

}
