package nl.uva.se.ql.typechecking.error;

import nl.uva.se.ql.ast.statement.Question;

public class IncompatibleTypeDeclaration extends Error {

	public IncompatibleTypeDeclaration(Question original, Question duplicate) {
		super(duplicate.getLineNumber(), duplicate.getOffset(),
				"incompatible type declaration", original.getId()
						+ " already defined as " + original.getType() + " (at "
						+ original.getLineNumber() + ":" + original.getOffset()
						+ ")");
	}

}
