package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.LtGtLeGeContext;
import org.uva.sea.ql.encoders.EncodersQLParser.MulDivContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NeEqContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NotContext;
import org.uva.sea.ql.encoders.EncodersQLParser.OrContext;
import org.uva.sea.ql.encoders.ast.Expression;

public class ExpressionVisitor extends EncodersQLBaseVisitor<Expression> {

	@Override
	public Expression visitNeEq(NeEqContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = visit(ctx.expression(0));
		Expression rightHand = visit(ctx.expression(1));
		return new Expression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitMulDiv(MulDivContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = visit(ctx.expression(0));
		Expression rightHand = visit(ctx.expression(1));
		Expression expression = new Expression(leftHand, rightHand, operator);
		return expression;
	}

	@Override
	public Expression visitLtGtLeGe(LtGtLeGeContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = visit(ctx.expression(0));
		Expression rightHand = visit(ctx.expression(1));
		Expression expression = new Expression(leftHand, rightHand, operator);
		return expression;
	}

	@Override
	public Expression visitNot(NotContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = visit(ctx.expression(0));
		Expression rightHand = visit(ctx.expression(1));
		Expression expression = new Expression(leftHand, rightHand, operator);
		return expression;
	}

	@Override
	public Expression visitOr(OrContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = visit(ctx.expression(0));
		Expression rightHand = visit(ctx.expression(1));
		Expression expression = new Expression(leftHand, rightHand, operator);
		return expression;
	}
}
