package org.uva.ql.visitor;

public interface StatementVisitable {
	public <T> T accept(StatementVisitor<T> visitor);
}
