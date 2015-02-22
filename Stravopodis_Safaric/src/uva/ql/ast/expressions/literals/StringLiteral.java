package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.ExpressionVisitor;
import uva.ql.ast.value.StringValue;

public class StringLiteral extends Literal{
	
	private String value;
	
	public StringLiteral(CodeLines _codeLines) {
		super(_codeLines);
	}
	public StringLiteral(String _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	@Override
	public String toString(){
		if (this.value != null) return "StringLiteral(" + this.value + ")";
		else return "StringLiteral()";
	}
	@Override
	public StringValue evaluate() {
		return new StringValue(this.value);
	}
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitStringLiteral(this);
		
	}
}
