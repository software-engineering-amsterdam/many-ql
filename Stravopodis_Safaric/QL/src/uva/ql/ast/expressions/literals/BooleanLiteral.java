package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class BooleanLiteral extends Literal{
	
	private boolean value;
	
	public BooleanLiteral(boolean _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	@Override
	public Boolean getValue() {
		return this.value;
	}
	
	@Override
	public BooleanValue evaluate() {
		return new BooleanValue(this.value);
	}

	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public List<Type> acceptedTypes() {
		return null;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitBooleanLiteral(this);
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}
	
	@Override
	public String toString() {
		return "BooleanLiteral(" + String.valueOf(this.value) + ")";
	}
}
