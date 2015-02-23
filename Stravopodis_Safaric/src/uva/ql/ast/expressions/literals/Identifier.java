package uva.ql.ast.expressions.literals;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Identifier extends Literal{
	private String identifier;
	
	public Identifier(String _identifier, CodeLines _codeLines){
		super(_codeLines);
		this.identifier = _identifier;
	}
	@Override
	public String toString() {
		return "Identifier(" + this.identifier + ")";
	}
	@Override
	public StringValue evaluate() {
		return new StringValue(this.identifier);
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitIdentifier(this);
	}
}
