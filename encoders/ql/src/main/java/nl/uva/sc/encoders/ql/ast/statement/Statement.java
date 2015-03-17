package nl.uva.sc.encoders.ql.ast.statement;

import java.util.Collection;

import nl.uva.sc.encoders.ql.ast.AstNodeWithLocation;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.visitor.StatementVisitor;

public abstract class Statement extends AstNodeWithLocation {

	public Statement(TextLocation textLocation) {
		super(textLocation);
	}

	public abstract <T> T accept(StatementVisitor<T> visitor);

	public abstract void collectQuestions(Collection<Question> questions);

}
