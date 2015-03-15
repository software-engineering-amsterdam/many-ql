package org.uva.sea.ql.encoders.ast;

import java.util.List;

public abstract class Statement extends AstNode {

	public Statement(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract List<Question> getQuestions();

}
