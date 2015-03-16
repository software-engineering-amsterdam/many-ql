package org.uva.sea.ql.encoders.ast.statement;

import java.util.Collection;

import org.uva.sea.ql.encoders.ast.AstNodeWithLocation;
import org.uva.sea.ql.encoders.ast.TextLocation;

public abstract class Statement extends AstNodeWithLocation {

	public Statement(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract void collectQuestions(Collection<Question> questions);

}
