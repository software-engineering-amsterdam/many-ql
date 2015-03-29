package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;

public abstract class Literal extends Expression{

	public Literal(){
		super();
	}
	
	public Literal(CodeLines codeLines) {
		super(codeLines);
	}
	
	@Override
	public boolean isLiteral(){
		return true;
	}
	
	@Override
	public boolean isBinaryExpression(){
		return false;
	}
}

