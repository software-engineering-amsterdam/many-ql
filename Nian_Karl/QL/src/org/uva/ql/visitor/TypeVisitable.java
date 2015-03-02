package org.uva.ql.visitor;

public interface TypeVisitable {
	public <T> T accept(TypeVisitor<T> visitor);

}
