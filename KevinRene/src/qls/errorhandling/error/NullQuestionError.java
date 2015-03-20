package qls.errorhandling.error;

import ql.ast.expression.Identifier;

public class NullQuestionError extends qls.errorhandling.Error {
	public NullQuestionError(Identifier origin) {
		super(origin, "Question with (" + origin.getClass().getSimpleName() 
				+  ":" + origin + ") does not exist.");
	}
}
