package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class IntLiteral extends Literal{
	
	private Integer value;
	
	public IntLiteral(Integer _value, CodeLines _codeLines) {
		super(_codeLines);
		this.value = _value;
	}
	public IntLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.value.floatValue());
	}
	@Override
	public String toString(){
		if (this.value == null) return "IntegerLiteral()";
		else return "IntegerLiteral(" + String.valueOf(this.value) + ")";
	}
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitIntLiteral(this);
	}
}
