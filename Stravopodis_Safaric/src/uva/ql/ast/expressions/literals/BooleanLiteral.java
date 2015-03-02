package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class BooleanLiteral extends Literal{
	
	private boolean value;
	
	public BooleanLiteral(boolean _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	public BooleanLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	
	@Override
	public BooleanValue evaluate() {
		return new BooleanValue(this.value);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitBooleanLiteral(this);
	}
	
	@Override
	public String evaluateType() {
		return BooleanLiteral.class.getName();
	}
	
	@Override
	public String toString() {
		return "BooleanLiteral(" + String.valueOf(this.value) + ")";
	}
}
