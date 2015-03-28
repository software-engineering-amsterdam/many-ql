package uva.ql.ast.expressions.literals;

import java.util.Arrays;
import java.util.List;
import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.expression.evaluation.ValueTable;
import uva.ql.ast.visitor.ExpressionVisitor;

public class Identifier extends Literal{
	
	private String identifier;
	
	public Identifier(String _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
	}
	
	public GenericValue<?> getValueFromValueTable(ValueTable valueTable){
		return valueTable.getValue(this.identifier);
	}
	
	@Override
	public String getValue() {
		return this.identifier;
	}
	
	@Override
	public StringValue evaluate() {
		return new StringValue(this.identifier);
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
		return visitor.visitIdentifier(this);
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null){
			return false;
		}
		return ((Identifier)obj).identifier.equals(this.identifier);
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}
	
	@Override
	public String toString() {
		return "Identifier(" + this.identifier + ")";
	}
}
