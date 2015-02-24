package org.uva.sea.ql.AST.statement;

import org.uva.sea.ql.AST.QuestionType;
import org.uva.sea.ql.AST.visitor.Visitor;


public class QuestionStatement extends Statement {
	private final QuestionType questionType;
	private final String identifier;
	private final String questionLabel;


	public QuestionStatement(QuestionType questionType, String identifier,
			String questionLabel) {
		super();
		this.questionType = questionType;
		this.identifier = identifier;
		this.questionLabel = questionLabel;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getQuestionLabel() {
		return questionLabel;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	@Override
	public String toString() {
		return "questionType = " + questionType
				+"\n identifier =  " + identifier
				+"\n questionLabel =  " + questionLabel;
	}
}
