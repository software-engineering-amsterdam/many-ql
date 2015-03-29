package ql.ast.expression;

import java.util.Arrays;

import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.type.QLError;
import ql.ast.visitor.ExpressionVisitor;

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
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return identifier;
	}
	
	@Override
	public int hashCode() {
		return identifier.hashCode();
	}
	
	@Override
	public boolean equals(Object comparisonObject) {
		if(comparisonObject instanceof Identifier) {
			return hashCode() == ((Identifier) comparisonObject).hashCode();
		}
		
		return false;
	}
}