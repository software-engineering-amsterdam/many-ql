package nl.uva.se.visitor;

import nl.uva.se.parser.QLBaseVisitor;
import nl.uva.se.parser.QLParser.AdditiveExpressionContext;
import nl.uva.se.parser.QLParser.AndExpressionContext;
import nl.uva.se.parser.QLParser.ConditionDeclarationContext;
import nl.uva.se.parser.QLParser.EqualExpressionContext;
import nl.uva.se.parser.QLParser.FormDeclarationContext;
import nl.uva.se.parser.QLParser.MultiplicationExpressionContext;
import nl.uva.se.parser.QLParser.NotExpressionContext;
import nl.uva.se.parser.QLParser.OrExpressionContext;
import nl.uva.se.parser.QLParser.QuestionDeclarationContext;
import nl.uva.se.parser.QLParser.RelationalExpressionContext;
import nl.uva.se.parser.QLParser.StatementContext;
import nl.uva.se.parser.QLParser.TypeContext;

public class QLVisitorImpl extends QLBaseVisitor<Object> {
	
	private int i = 1;
	
	/* @Override
	public Object visitFormDeclaration(FormDeclarationContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitQuestionDeclaration(QuestionDeclarationContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}



	@Override
	public Object visitConditionDeclaration(ConditionDeclarationContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}



	@Override
	public Object visitStatement(StatementContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}



	@Override
	public Object visitAndExpression(AndExpressionContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitRelationalExpression(RelationalExpressionContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitNotExpression(NotExpressionContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitOrExpression(OrExpressionContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitAdditiveExpression(AdditiveExpressionContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitMultiplicationExpression(
			MultiplicationExpressionContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitEqualExpression(EqualExpressionContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitType(TypeContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	} */

}
