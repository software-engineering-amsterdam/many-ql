package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.ExpressionVisitor;
import uva.ql.ast.value.NumberValue;

public class DecimalLiteral extends Literal{	
	
	private float value;
	
	public DecimalLiteral(float _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	public DecimalLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.value);
	}
	@Override
	public String toString(){
		return "DecimalLiteral(" + String.valueOf(this.value) + ")";
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitDecimalLiteral(this);
	}
}
