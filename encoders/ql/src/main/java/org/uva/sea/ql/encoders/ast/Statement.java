package org.uva.sea.ql.encoders.ast;

import java.util.Collection;

public abstract class Statement extends AstNode {

	public Statement(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract void collectQuestions(Collection<Question> questions);

}
