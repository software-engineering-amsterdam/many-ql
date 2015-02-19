package ql.ast.expression;

import ql.ast.value.Value;

public abstract class Expression {
	
	public abstract Value<?> evaluate();
}
