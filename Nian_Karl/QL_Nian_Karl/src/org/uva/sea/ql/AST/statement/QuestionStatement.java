package org.uva.sea.ql.AST.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.QuestionType;


public class QuestionStatement extends Statement implements Node{
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
	public List<Node> visit() {
		List<Node> nodes =new ArrayList<Node>();
		nodes.add(this);
		return nodes;
		// probably return questionType identifier quetionLabel
	}
}
