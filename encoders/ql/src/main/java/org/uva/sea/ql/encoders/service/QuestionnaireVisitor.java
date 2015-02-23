package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.ComputationContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalBlockContext;
import org.uva.sea.ql.encoders.EncodersQLParser.ConditionalContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionnaireContext;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Expression;
import org.uva.sea.ql.encoders.ast.Question;
import org.uva.sea.ql.encoders.ast.Questionnaire;

public class QuestionnaireVisitor extends EncodersQLBaseVisitor<Void> {

	private final Questionnaire questionnaire = new Questionnaire();

	private String condition = null;

	private final ExpressionVisitor expressionVisitor = new ExpressionVisitor();

	@Override
	public Void visitQuestionnaire(QuestionnaireContext ctx) {
		questionnaire.setName(ctx.formName.getText());
		return null;
	}

	@Override
	public Void visitQuestion(QuestionContext ctx) {
		String questionName = ctx.questionName.getText();
		DataType dataType = DataType.valueOf(ctx.type.getText().toUpperCase());
		String questionString = ctx.questionString.getText();
		questionString = questionString.replaceAll("\"", "");

		Question question = new Question(questionName, condition, dataType,
				questionString);
		questionnaire.addQuestion(question);
		return null;
	}

	@Override
	public Void visitConditional(ConditionalContext ctx) {
		this.condition = ctx.getText();
		return null;
	}

	@Override
	public Void visitComputation(ComputationContext ctx) {
		Expression expression2 = expressionVisitor.visit(ctx.expression());
		return null;
	}

	@Override
	public Void visitConditionalBlock(ConditionalBlockContext ctx) {
		this.condition = null;
		return null;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

}
