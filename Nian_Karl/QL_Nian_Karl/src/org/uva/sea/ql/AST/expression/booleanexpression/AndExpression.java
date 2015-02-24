package org.uva.sea.ql.AST.expression.booleanexpression;

import org.uva.sea.ql.AST.expression.BinaryExpression;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.value.BooleanValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public class AndExpression extends BinaryExpression {

	public AndExpression(Expression leftExpression, Expression rightExpression){
		super(leftExpression, rightExpression);
		
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
