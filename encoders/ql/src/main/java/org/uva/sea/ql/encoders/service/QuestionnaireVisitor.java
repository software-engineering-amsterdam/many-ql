package org.uva.sea.ql.encoders.service;

import java.util.List;

import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.AddSubContext;
import org.uva.sea.ql.encoders.EncodersQLParser.AndContext;
import org.uva.sea.ql.encoders.EncodersQLParser.BracedExpressionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ExpressionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.LtGtLeGeContext;
import org.uva.sea.ql.encoders.EncodersQLParser.MulDivContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NameContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NeEqContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NotContext;
import org.uva.sea.ql.encoders.EncodersQLParser.OrContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.EncodersQLParser.StatementContext;
import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.ast.BracedExpression;
import org.uva.sea.ql.encoders.ast.ConditionalBlock;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.NameExpression;
import org.uva.sea.ql.encoders.ast.OperatorExpression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;

public class QuestionnaireVisitor extends EncodersQLBaseVisitor<AstNode> {

	@Override
	public Questionnaire visitQuestionnaire(QuestionnaireContext ctx) {
		Questionnaire questionnaire = new Questionnaire();
		questionnaire.setName(ctx.formName.getText());
		List<StatementContext> statements = ctx.statement();

		for (StatementContext statementContext : statements) {
			ConditionalBlockContext conditionalBlock = statementContext
					.conditionalBlock();
			if (conditionalBlock != null) {
				ConditionalBlock cb = (ConditionalBlock) visit(conditionalBlock);
				questionnaire.addQuestions(cb.getQuestions());
			}
			QuestionContext questionContext = statementContext.question();
			if (questionContext != null) {
				Question question = (Question) visit(questionContext);
				questionnaire.addQuestion(question);
			}
		}
		return questionnaire;
	}

	@Override
	public ConditionalBlock visitConditionalBlock(ConditionalBlockContext ctx) {
		ConditionalBlock cb = new ConditionalBlock();
		for (QuestionContext questionContext : ctx.question()) {
			Question question = (Question) visit(questionContext);
			cb.add(question);
		}
		return cb;
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
		String questionName = ctx.questionName.getText();
		DataType dataType = DataType.valueOf(ctx.type.getText().toUpperCase());
		String questionString = ctx.questionString.getText();
		questionString = questionString.replaceAll("\"", "");

		Question question = new Question(questionName, dataType, questionString);
		if (ctx.parent instanceof ConditionalBlockContext) {
			ConditionalBlockContext parent = (ConditionalBlockContext) ctx.parent;
			String condition = parent.conditional().NAME().getText();
			question.setCondition(condition);
		}
		ExpressionContext expressionContext = ctx.expr;
		if (expressionContext != null) {
			Expression expression = (Expression) visit(expressionContext);
			question.setExpression(expression);
			System.out.println(expression);
		}
		super.visitChildren(ctx);
		return question;
	}

	@Override
	public Expression visitNeEq(NeEqContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		return new OperatorExpression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitMulDiv(MulDivContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		return new OperatorExpression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitLtGtLeGe(LtGtLeGeContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		return new OperatorExpression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitNot(NotContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		return new OperatorExpression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitOr(OrContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		return new OperatorExpression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitAddSub(AddSubContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		return new OperatorExpression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitAnd(AndContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		return new OperatorExpression(leftHand, rightHand, operator);
	}

	@Override
	public Expression visitBracedExpression(BracedExpressionContext ctx) {
		Expression expression = (Expression) visit(ctx.expression());
		return new BracedExpression(expression);
	}

	@Override
	public Expression visitName(NameContext ctx) {
		return new NameExpression(ctx.name.getText());
	}
}
