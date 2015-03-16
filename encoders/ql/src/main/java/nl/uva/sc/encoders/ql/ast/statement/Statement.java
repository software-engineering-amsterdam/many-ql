package nl.uva.sc.encoders.ql.ast.statement;

import java.util.Collection;

import nl.uva.sc.encoders.ql.ast.AstNodeWithLocation;
import nl.uva.sc.encoders.ql.ast.TextLocation;

public abstract class Statement extends AstNodeWithLocation {

	public Statement(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract void collectQuestions(Collection<Question> questions);

}
