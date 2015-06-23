package uva.qls.ast.literal;

import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.NumberValue;
import uva.qls.ast.CodeLines;

public class MoneyLiteral extends Literal {
	
	private Integer value;
	
	public MoneyLiteral(Integer _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitMoneyLiteral(this);
	}

	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.value);
	}

	@Override
	public String toString(){
		return "MoneyLiteral(" + this.value + ")";
	}	
	
	

}
