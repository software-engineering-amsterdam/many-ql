package org.uva.ql.ast.statement;

import org.uva.ql.ast.type.QuestionType;
import org.uva.ql.ast.visitor.Visitor;



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
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "QuestionType = " +  questionType
				+"\n QuestionIdentifier = " + identifier
				+"\n QuestionLabel = " + questionLabel;
				
	}
}
