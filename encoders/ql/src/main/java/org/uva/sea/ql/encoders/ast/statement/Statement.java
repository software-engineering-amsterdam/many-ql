package org.uva.sea.ql.encoders.ast.statement;

import java.util.Collection;

import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.ast.TextLocation;

public abstract class Statement extends AstNode {

	public Statement(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract void collectQuestions(Collection<Question> questions);

}
