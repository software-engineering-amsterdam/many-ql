package org.uva.sea.ql.AST.visitor;

import org.uva.sea.ql.AST.Node;
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

	public void visit(Node node);
	public AbstractValue<T> visit(AddExpression expr);
	public AbstractValue<T> visit(SubExpression expr);
	public AbstractValue<T> visit(MulExpression expr);
	public AbstractValue<T> visit(DivExpression expr);
	
	public AbstractValue<T> visit(AndExpression expr);
	public AbstractValue<T> visit(EqualExpression expr);
	public AbstractValue<T> visit(GreaterEqualExpression expr);
	public AbstractValue<T> visit(GreaterExpression expr);
	public AbstractValue<T> visit(LessEqualExpression expr);
	public AbstractValue<T> visit(LessExpression expr);
	public AbstractValue<T> visit(OrExpression expr);
	public AbstractValue<T> visit(NegativeExpression expr);
	public AbstractValue<T> visit(NotExpression expr);
	public AbstractValue<T> visit(PositiveExpression expr);
	
	
}
