package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class StringLiteral extends Literal{
	
	private String value;
	
	public StringLiteral(String _value){
		super(new CodeLines(0,0));	// Set an initial value
		this.value = _value;
	}
	
	public StringLiteral(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public StringLiteral(String _value, CodeLines _codeLines){
		super(_codeLines);
		this.value = _value;
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}
	
	@Override
	public StringValue evaluate() {
		return new StringValue(this.value);
	}
	
	@Override
	public String getValue() {
		return this.evaluate().getValue();
	}
	
	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeString());
	}
	
	@Override
	public List<Type> acceptedTypes() {
		return null;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitStringLiteral(this);	
	}

	@Override
	public String toString(){
		return "StringLiteral(" + this.value + ")";
	}
}
