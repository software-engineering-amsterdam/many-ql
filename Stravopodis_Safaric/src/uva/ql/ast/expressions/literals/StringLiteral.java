package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;

public class StringLiteral extends Value<String>{
	
	private String value;
	
	public StringLiteral(CodeLines _codeLines) {
		super(_codeLines);
	}
	public StringLiteral(String _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	public String getValue(){
		return this.value;
	}
	@Override
	public String toString(){
		if (this.value != null) return "StringLiteral(" + this.value + ")";
		else return "StringLiteral()";
	}
}
