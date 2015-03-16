package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class Identifier extends Literal{
	
	private String identifier;
	
	public Identifier(){
		super(null);
	}
	
	public Identifier(String _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public StringValue evaluate() {
		return new StringValue(this.identifier);
	}
	
	@Override
	public List<Type> getValueType() {
		return Arrays.asList(new TypeString());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeString());
	}
	
	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitIdentifier(this);
	}
	
	@Override
	public String toString() {
		return "Identifier(" + this.identifier + ")";
	}
}
