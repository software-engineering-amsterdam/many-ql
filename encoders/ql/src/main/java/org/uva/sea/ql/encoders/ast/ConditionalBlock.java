package org.uva.sea.ql.encoders.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.encoders.visitor.AstVisitor;

public class ConditionalBlock extends AstNode {

	public ConditionalBlock(TextLocation textLocation) {
		super(textLocation);
	}

	private final List<Question> questions = new ArrayList<Question>();

	public void add(Question question) {
		questions.add(question);
	}

	public List<Question> getQuestions() {
		return questions;
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
