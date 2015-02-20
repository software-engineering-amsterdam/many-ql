package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;


public class IntLiteral extends Value<Integer>{
	
	private Integer value;
	
	public IntLiteral(Integer _value, CodeLines _codeLines) {
		super(_codeLines);
		this.value = _value;
	}
	public IntLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	public Integer getValue(){
		return this.value;
	}
	@Override
	public String toString(){
		if (this.value == null) return "Integer()";
		else return "Integer(" + String.valueOf(this.getValue()) + ")";
	}
	
}
