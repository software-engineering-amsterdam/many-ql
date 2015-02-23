package org.uva.sea.ql.encoders.service;

import org.uva.sea.ql.encoders.EncodersQLBaseVisitor;
import org.uva.sea.ql.encoders.EncodersQLParser.QuestionContext;
import org.uva.sea.ql.encoders.ast.DataType;
import org.uva.sea.ql.encoders.ast.Question;

public class QuestionVisitor extends EncodersQLBaseVisitor<Question> {

	private final String condition;

	public QuestionVisitor(String condition) {
		this.condition = condition;
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
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
