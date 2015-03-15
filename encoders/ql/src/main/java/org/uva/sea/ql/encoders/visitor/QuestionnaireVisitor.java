package org.uva.sea.ql.encoders.visitor;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.AddSubContext;
import org.uva.sea.ql.encoders.EncodersQLParser.AndContext;
import org.uva.sea.ql.encoders.EncodersQLParser.BooleanLiteralContext;
import org.uva.sea.ql.encoders.EncodersQLParser.BracedExpressionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ExpressionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.IntegerLiteralContext;
import org.uva.sea.ql.encoders.EncodersQLParser.LtGtLeGeContext;
import org.uva.sea.ql.encoders.EncodersQLParser.MulDivContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NameExpressionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NeEqContext;
import org.uva.sea.ql.encoders.EncodersQLParser.NotContext;
import org.uva.sea.ql.encoders.EncodersQLParser.OrContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.EncodersQLParser.StatementContext;
import org.uva.sea.ql.encoders.EncodersQLParser.StringLiteralContext;
import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.ast.ConditionalBlock;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;
import org.uva.sea.ql.encoders.ast.TextLocation;
import org.uva.sea.ql.encoders.ast.expression.BinaryExpression;
import org.uva.sea.ql.encoders.ast.expression.BooleanExpression;
import org.uva.sea.ql.encoders.ast.expression.BracedExpression;
import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.expression.IntegerExpression;
import org.uva.sea.ql.encoders.ast.expression.NameExpression;
import org.uva.sea.ql.encoders.ast.expression.StringExpression;
import org.uva.sea.ql.encoders.ast.expression.UnaryExpression;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.ast.type.DataTypeTable;

public class QuestionnaireVisitor extends EncodersQLBaseVisitor<AstNode> {

	@Override
	public Questionnaire visitQuestionnaire(QuestionnaireContext ctx) {
		Questionnaire questionnaire = new Questionnaire(getTextLocation(ctx));
		questionnaire.setName(ctx.formName.getText());
		List<StatementContext> statements = ctx.statement();

		for (StatementContext statementContext : statements) {
			ConditionalBlockContext conditionalBlock = statementContext.conditionalBlock();
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
		ConditionalBlock cb = new ConditionalBlock(getTextLocation(ctx));
		for (QuestionContext questionContext : ctx.question()) {
			Question question = (Question) visit(questionContext);
			cb.add(question);
		}
		return cb;
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
		String questionName = ctx.questionName.getText();
		DataTypeTable dataTypeTable = new DataTypeTable();
		DataType dataType = dataTypeTable.get(ctx.type.getText());
		if (dataType == null) {
			throw new IllegalStateException("Unknown dataType " + ctx.type.getText());
		}
		String questionString = ctx.questionString.getText();
		questionString = removeFirstAndListCharOfString(questionString);
		questionString = unescapedString(questionString);

		TextLocation textLocation = getTextLocation(ctx);
		Question question = new Question(textLocation, questionName, dataType, questionString);
		if (ctx.parent instanceof ConditionalBlockContext) {
			ConditionalBlockContext parent = (ConditionalBlockContext) ctx.parent;
			Expression condition = (Expression) visit(parent.expression());
			question.setCondition(condition);
		}
		ExpressionContext computedCtx = ctx.computed;
		if (computedCtx != null) {
			Expression computed = (Expression) visit(computedCtx);
			question.setComputed(computed);
			System.out.println(computed);
		}
		super.visitChildren(ctx);
		return question;
	}

	private String removeFirstAndListCharOfString(String string) {
		return string.substring(1, string.length() - 1);
	}

	private String unescapedString(String escapedString) {
		return escapedString.replaceAll("\\\\\"", "\\\"");
	}

	@Override
	public Expression visitBracedExpression(BracedExpressionContext ctx) {
		Expression expression = (Expression) visit(ctx.expression());
		TextLocation textLocation = getTextLocation(ctx);
		return new BracedExpression(textLocation, expression);
	}

	@Override
	public Expression visitNameExpression(NameExpressionContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String text = ctx.name.getText();
		return new NameExpression(textLocation, text);
	}

	@Override
	public Expression visitNeEq(NeEqContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitMulDiv(MulDivContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitLtGtLeGe(LtGtLeGeContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitOr(OrContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitAddSub(AddSubContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitAnd(AndContext ctx) {
		String operator = ctx.operator.getText();
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, operator);
	}

	@Override
	public Expression visitNot(NotContext ctx) {
		String operator = ctx.operator.getText();
		Expression expression = (Expression) visit(ctx.expr);
		TextLocation textLocation = getTextLocation(ctx);
		return new UnaryExpression(textLocation, operator, expression);
	}

	@Override
	public Expression visitBooleanLiteral(BooleanLiteralContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		Boolean booleanLiteral = Boolean.valueOf(ctx.value.getText());
		return new BooleanExpression(textLocation, booleanLiteral);
	}

	@Override
	public Expression visitIntegerLiteral(IntegerLiteralContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		Integer integerLiteral = Integer.valueOf(ctx.value.getText());
		return new IntegerExpression(textLocation, integerLiteral);
	}

	@Override
	public Expression visitStringLiteral(StringLiteralContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String stringLiteral = ctx.value.getText();
		return new StringExpression(textLocation, stringLiteral);
	}

	private TextLocation getTextLocation(ParserRuleContext ctx) {
		Token start = ctx.getStart();
		int line = start.getLine();
		int charPositionInLine = start.getCharPositionInLine();
		return new TextLocation(line, charPositionInLine);
	}

}
