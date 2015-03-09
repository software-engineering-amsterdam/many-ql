package org.uva.ql.visitor;

public interface ExpressionVisitable {
	public <T> T accept (ExpressionVisitor<T> visitor);
}
