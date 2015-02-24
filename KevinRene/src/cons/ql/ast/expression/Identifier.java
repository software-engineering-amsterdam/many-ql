package cons.ql.ast.expression;

import java.util.Arrays;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.type.QLError;
import cons.ql.ast.visitor.Visitor;

public class Identifier extends Expression {
	private final String identifier;
	
	public Identifier(String identifier) {
		super(Arrays.asList());
		this.identifier = identifier;
	}
	
	@Override
	public QLType getType() {
		return new QLError();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return identifier;
	}	
}
