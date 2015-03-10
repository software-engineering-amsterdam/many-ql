package org.uva.qls.visitor;

public interface StyleVisitable {
	public <T> T accept(StyleVisitor<T> visitor);
}
