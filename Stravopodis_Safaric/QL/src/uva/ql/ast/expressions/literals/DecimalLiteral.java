package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

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
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitDecimalLiteral(this);
	}
	
	@Override
	public String evaluateType() {
		return DecimalLiteral.class.getName();
	}
	
	@Override
	public String toString(){
		return "DecimalLiteral(" + String.valueOf(this.value) + ")";
	}
}
