package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class MoneyLiteral extends Literal{	
	
	private Integer value;
	
	public MoneyLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	
	public MoneyLiteral(Integer _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.value);
	}
	
	@Override
	public List<Type> getValueType() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitMoneyLiteral(this);
	}
	
	@Override
	public String toString(){
		return "MoneyLiteral(" + this.value + ")";
	}
}
