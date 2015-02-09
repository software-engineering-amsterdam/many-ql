package org.uva.sea.ql.parser.impl;

import org.uva.sea.ql.parser.antlr.QLBaseVisitor;
import org.uva.sea.ql.parser.antlr.QLParser.AdditionContext;
import org.uva.sea.ql.parser.antlr.QLParser.NumberContext;
import org.uva.sea.ql.parser.antlr.QLParser.PlusExprContext;

public class QLImplVisitor extends QLBaseVisitor<String> {

	@Override
	public String visitPlusExpr(PlusExprContext ctx) {
		return visitChildren(ctx)+ "\n" + ctx.right.getText() + "\n" + "addition";
	}
	
	
	@Override
	public String visitNumber(NumberContext ctx) {
		return ctx.Number.getText();
	}
	
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if (aggregate == null) {
			return nextResult;
		}
		if (nextResult == null) {
			return aggregate;
		}
		return aggregate + "\n" + nextResult;
	}
}
