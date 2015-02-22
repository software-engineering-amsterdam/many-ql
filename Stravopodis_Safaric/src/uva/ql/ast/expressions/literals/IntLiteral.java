package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.ExpressionVisitor;
import uva.ql.ast.value.NumberValue;

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
		return new NumberValue(this.value);
	}
	@Override
	public String toString(){
		if (this.value == null) return "Integer()";
		else return "Integer(" + String.valueOf(this.value) + ")";
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitIntLiteral(this);
	}
}
