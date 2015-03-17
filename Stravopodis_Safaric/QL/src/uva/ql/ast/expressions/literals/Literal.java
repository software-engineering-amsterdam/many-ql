package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.value.GenericValue;

public abstract class Literal extends Expression{

	public Literal(CodeLines codeLines) {
		super(codeLines);
	}
	
	@Override
	public abstract String toString();
	public abstract GenericValue<?> evaluate();
}

