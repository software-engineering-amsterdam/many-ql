package nl.uva.se.interpreter.error;

import nl.uva.se.ast.statement.Question;

public class IncompatibleTypeDeclaration extends Error {

	public IncompatibleTypeDeclaration(Question original, Question duplicate) {
		super(duplicate.getLineNumber(), duplicate.getOffset(),
				"incompatible type declaration", original.getId()
						+ " already defined as " + original.getType() + " (at "
						+ original.getLineNumber() + ":" + original.getOffset()
						+ ")");
	}

}
