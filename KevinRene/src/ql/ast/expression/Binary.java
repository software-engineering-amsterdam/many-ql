package ql.ast.expression;

import java.util.Arrays;

import ql.ast.Expression;

public abstract class Binary extends Expression {
	
	private Expression left, right;
	private String operator;
	
	public Binary(Expression left, Expression right, String operator) {
		super(Arrays.asList(left, right));
		this.left = left;
		this.right = right;
		this.operator = operator;
	}
	
	public Expression getLeft() {
		return this.left;
	}
	
	public Expression getRight() {
		return this.right;
	}
	
	@Override
	public String toString() {
		return left.toString() + " " + operator + " " + right.toString();
	}
}