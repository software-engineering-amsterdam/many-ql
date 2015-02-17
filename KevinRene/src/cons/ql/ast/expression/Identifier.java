package cons.ql.ast.expression;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.Visitor;

public class Identifier extends Expression {
	private final String identifier;
	
	public Identifier(String identifier) {
		this.identifier = identifier;
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return identifier;
	}	
}
