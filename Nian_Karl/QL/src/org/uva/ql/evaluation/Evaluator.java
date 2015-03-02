package org.uva.ql.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.association.Parenthese;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Minus;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Plus;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.ast.expression.unary.Positive;
import org.uva.ql.ast.value.Bool;
import org.uva.ql.ast.value.Int;
import org.uva.ql.ast.value.Str;
import org.uva.ql.ast.value.Undefined;
import org.uva.ql.ast.value.Value;
import org.uva.ql.visitor.ExpressionVisitor;

public class Evaluator implements ExpressionVisitor<Value> {

	private final Map<String, Value> values;

	public Evaluator() {
		values = new HashMap<String, Value>();
	}

	public void addValue(String name, Value value) {
		values.put(name, value);
	}

	public boolean contains(String name) {
		return values.containsKey(name);
	}
	
	public Value getValue(String name) {
		if (contains(name)) {
			return values.get(name);
		} else {
			System.out.println("Question <" + name + "> does not exist.");
			return new Undefined();
		}
	}
	
	public int countValues() {
		return values.size();
	}

	public Value evaluate(Expression expr) {
		return expr.accept(this);
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
		return node.getValue(this);
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
