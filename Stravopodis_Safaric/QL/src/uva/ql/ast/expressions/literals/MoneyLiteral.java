package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class MoneyLiteral extends Literal{	
	
	private int value;
	
	public MoneyLiteral(int _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	public MoneyLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.value);
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitMoneyLiteral(this);
	}
	
	@Override
	public String evaluateType() {
		return MoneyLiteral.class.getName();
	}
	
	@Override
	public String toString(){
		return "DecimalLiteral(" + String.valueOf(this.value) + ")";
	}
}
