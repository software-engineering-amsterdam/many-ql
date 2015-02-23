package org.uva.sea.ql.encoders.service;

import java.util.List;

import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.ComputationContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.EncodersQLParser.StatementContext;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;

public class QuestionnaireVisitor extends EncodersQLBaseVisitor<Void> {

	private final Questionnaire questionnaire = new Questionnaire();

	private final ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	private final ConditionalVisitor conditionalVisitor = new ConditionalVisitor();
	private final QuestionVisitor noConditionalQuestionVisitor = new QuestionVisitor(
			null);

	@Override
	public Void visitQuestionnaire(QuestionnaireContext ctx) {
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
				Question question = noConditionalQuestionVisitor
						.visit(questionContext);
				questionnaire.addQuestion(question);
			}
		}
		return null;
	}

	@Override
	public Void visitComputation(ComputationContext ctx) {
		Expression expression2 = (Expression) expressionVisitor.visit(ctx
				.expression());
		visitChildren(ctx);
		return null;
	}

	@Override
	public Void visitConditionalBlock(ConditionalBlockContext ctx) {
		String condition = conditionalVisitor.visit(ctx.conditional());
		QuestionVisitor questionVisitor = new QuestionVisitor(condition);
		for (QuestionContext questionContext : ctx.question()) {
			Question question = questionVisitor.visit(questionContext);
			questionnaire.addQuestion(question);
		}
		return null;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

}
