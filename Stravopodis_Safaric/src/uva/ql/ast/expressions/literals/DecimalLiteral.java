package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;

public class DecimalLiteral extends Value<Float>{	
	
	float value;
	public DecimalLiteral(float _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	public DecimalLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	public Float getValue() {
		return this.value;
	}
	@Override
	public String toString(){
		return "DecimalLiteral(" + String.valueOf(this.value) + ")";
	}

}
