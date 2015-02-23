package org.uva.sea.ql.AST.expression;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.Visitor;
import org.uva.sea.ql.AST.value.AbstractValue;

public abstract class BinaryExpression extends Expression{
	protected Expression leftExpression;
	protected Expression rightExpression;
	
	public BinaryExpression(Expression leftExpression,
			Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	
	public Expression getLeftExpression() {
		return leftExpression;
	}


	public Expression getRightExpression() {
		return rightExpression;
	}

	public BinaryExpression() {
		
	}

	@Override
	public abstract AbstractValue<?> interpretExpression();
	
}
