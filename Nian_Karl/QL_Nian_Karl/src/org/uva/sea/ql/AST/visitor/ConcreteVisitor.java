package org.uva.sea.ql.AST.visitor;


import org.uva.sea.ql.AST.Form;
import org.uva.sea.ql.AST.Visitable;
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
import org.uva.sea.ql.AST.statement.BlockStatement;
import org.uva.sea.ql.AST.statement.IfStatement;
import org.uva.sea.ql.AST.statement.QuestionStatement;
import org.uva.sea.ql.AST.value.AbstractValue;

public class ConcreteVisitor implements Visitor<AbstractValue<?>> {

	@Override
	public void visit(Visitable node) {
	}

	@Override
	public AbstractValue<Integer> visit(AddExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(SubExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(MulExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(DivExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(AndExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(EqualExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(GreaterEqualExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(GreaterExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(LessEqualExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(LessExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(OrExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(NegativeExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(NotExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<AbstractValue<?>> visit(PositiveExpression expr) {
		return null;
	}

	@Override
	public AbstractValue<?> visit(Form form) {
		System.out.println("Visited");
		return null;
	}

	@Override
	public AbstractValue<?> visit(QuestionStatement questionStatement) {
		return null;
	}

	@Override
	public AbstractValue<?> visit(IfStatement ifStatement) {
		return null;
	}

	@Override
	public AbstractValue<?> visit(BlockStatement blockStatement) {
		System.out.println("Hello");
		return null;
	}
	
	

}
