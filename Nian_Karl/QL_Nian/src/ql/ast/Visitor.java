package ql.ast;

import ql.antlr.QLBaseVisitor;
import ql.antlr.QLParser.ExpressionContext;
import ql.ast.expression.Expression;

public class Visitor extends QLBaseVisitor<Expression>{
	
	@Override
	public Expression visitExpression(ExpressionContext ctx) {
		System.out.println(ctx.getText());
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}
	
}
