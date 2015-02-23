package org.uva.sea.ql.encoders.service;

import java.util.List;

import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.ComputationContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.EncodersQLParser.StatementContext;
import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;

public class QuestionnaireVisitor extends EncodersQLBaseVisitor<AstNode> {

	private final Questionnaire questionnaire = new Questionnaire();

	private final ExpressionVisitor expressionVisitor = new ExpressionVisitor();

	@Override
	public AstNode visitQuestionnaire(QuestionnaireContext ctx) {
		questionnaire.setName(ctx.formName.getText());
		List<StatementContext> statements = ctx.stmt;

		for (StatementContext statementContext : statements) {
			ConditionalBlockContext conditionalBlock = statementContext
					.conditionalBlock();
			if (conditionalBlock != null) {
				visit(conditionalBlock);
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
	public AstNode visitComputation(ComputationContext ctx) {
		Expression expression2 = (Expression) expressionVisitor.visit(ctx
				.expression());
		visitChildren(ctx);
		return null;
	}

	@Override
	public AstNode visitConditionalBlock(ConditionalBlockContext ctx) {
		for (QuestionContext questionContext : ctx.question()) {
			Question question = (Question) visit(questionContext);
			questionnaire.addQuestion(question);
		}
		return null;
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
		String condition = null;
		if (ctx.parent instanceof ConditionalBlockContext) {
			ConditionalBlockContext parent = (ConditionalBlockContext) ctx.parent;
			condition = parent.conditional().NAME().getText();
		}
		String questionName = ctx.questionName.getText();
		DataType dataType = DataType.valueOf(ctx.type.getText().toUpperCase());
		String questionString = ctx.questionString.getText();
		questionString = questionString.replaceAll("\"", "");

		Question question = new Question(questionName, condition, dataType,
				questionString);
		super.visitChildren(ctx);
		return question;
	}
}
