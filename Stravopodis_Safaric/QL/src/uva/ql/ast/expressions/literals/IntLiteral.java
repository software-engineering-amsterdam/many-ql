package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class IntLiteral extends Literal{
	
	private Integer value;
	
	public IntLiteral(Integer _value){
		super(new CodeLines(0,0));	// Set an initial value
		this.value = _value;
	}
	
	public IntLiteral(CodeLines _codeLines){
		super(_codeLines);
	}
	
	public IntLiteral(Integer _value, CodeLines _codeLines) {
		super(_codeLines);
		this.value = _value;
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue(this.value);
	}
	
	@Override
	public Object getValue() {
		return this.evaluate().getValue();
	}
	
	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public List<Type> acceptedTypes() {
		return null;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitIntLiteral(this);
	}
	
	@Override
	public String toString(){
		return "IntLiteral(" + this.value + ")";
	}
}
