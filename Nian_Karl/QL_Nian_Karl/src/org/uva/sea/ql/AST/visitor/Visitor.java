package org.uva.sea.ql.AST.visitor;

import org.uva.sea.ql.AST.Visitable;
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

public interface Visitor<T> {

	public void visit(Visitable node);
	public AbstractValue<?> visit(AddExpression expr);
	public AbstractValue<?> visit(SubExpression expr);
	public AbstractValue<?> visit(MulExpression expr);
	public AbstractValue<?> visit(DivExpression expr);
	
	public AbstractValue<?> visit(AndExpression expr);
	public AbstractValue<?> visit(EqualExpression expr);
	public AbstractValue<?> visit(GreaterEqualExpression expr);
	public AbstractValue<?> visit(GreaterExpression expr);
	public AbstractValue<?> visit(LessEqualExpression expr);
	public AbstractValue<?> visit(LessExpression expr);
	public AbstractValue<?> visit(OrExpression expr);
	public AbstractValue<?> visit(NegativeExpression expr);
	public AbstractValue<?> visit(NotExpression expr);
	public AbstractValue<?> visit(PositiveExpression expr);
	
	
}
