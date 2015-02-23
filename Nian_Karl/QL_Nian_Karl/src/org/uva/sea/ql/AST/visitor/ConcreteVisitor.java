package org.uva.sea.ql.AST.visitor;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.expression.booleanexpression.AndExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.EqualExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.GreaterEqualExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.GreaterExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.LessEqualExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.LessExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.OrExpression;
import org.uva.sea.ql.AST.expression.commonexpression.NegativeExpression;
import org.uva.sea.ql.AST.expression.commonexpression.NotExpression;
import org.uva.sea.ql.AST.expression.commonexpression.PositiveExpression;
import org.uva.sea.ql.AST.expression.mathexpression.AddExpression;
import org.uva.sea.ql.AST.expression.mathexpression.DivExpression;
import org.uva.sea.ql.AST.expression.mathexpression.MulExpression;
import org.uva.sea.ql.AST.expression.mathexpression.SubExpression;
import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.value.IntegerValue;

public class ConcreteVisitor implements Visitor<AbstractValue<?>>{

	@Override
	public void visit(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(AddExpression expr) {
		Expression left = expr.getLeftExpression();
		Expression right = expr.getRightExpression();
		IntegerValue leftValue = (IntegerValue) left.interpretExpression();
		IntegerValue rightValue = (IntegerValue) right.interpretExpression();
		return leftValue.add(rightValue);
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(SubExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(MulExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(DivExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(AndExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(EqualExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(GreaterEqualExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(GreaterExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(LessEqualExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(LessExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(OrExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(NegativeExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(NotExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(PositiveExpression expr) {
		// TODO Auto-generated method stub
		return null;
	}

}
