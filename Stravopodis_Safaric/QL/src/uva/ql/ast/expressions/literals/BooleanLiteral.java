package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
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
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public BooleanValue evaluate() {
		return new BooleanValue(this.value);
	}

	@Override
	public List<Type> getValueType() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitBooleanLiteral(this);
	}
	
	@Override
	public String toString() {
		return "BooleanLiteral(" + String.valueOf(this.value) + ")";
	}

}
