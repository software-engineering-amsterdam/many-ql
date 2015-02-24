package org.uva.ql.ast.statement;

import org.uva.ql.ast.type.QuestionType;
import org.uva.ql.ast.visitor.Visitor;



public class QuestionNormal extends Statement {
	private final QuestionType type;
	private final String identifier;
	private final String label;


	public QuestionNormal(QuestionType type, String identifier,
			String label) {
		super();
		this.type = type;
		this.identifier = identifier;
		this.label = label;
	}

	public QuestionType getQuestionType() {
		return type;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getQuestionLabel() {
		return label;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "QuestionType = " +  type
				+"\n QuestionIdentifier = " + identifier
				+"\n QuestionLabel = " + label;
				
	}
}
