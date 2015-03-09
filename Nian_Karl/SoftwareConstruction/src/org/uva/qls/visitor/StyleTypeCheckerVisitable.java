package org.uva.qls.visitor;

public interface StyleTypeCheckerVisitable {
	public <T> T accept(StyleVisitor<T> visitor);
}
