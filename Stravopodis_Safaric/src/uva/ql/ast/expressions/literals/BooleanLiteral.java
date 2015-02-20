package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;

public class BooleanLiteral extends Value<Boolean>{
	
	boolean value;
	
	public BooleanLiteral(boolean _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	public BooleanLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	public Boolean getValue() {
		return this.value;
	}
	@Override
	public String toString() {
		return "BooleanLiteral(" + String.valueOf(this.value) + ")";
	}
	
}
