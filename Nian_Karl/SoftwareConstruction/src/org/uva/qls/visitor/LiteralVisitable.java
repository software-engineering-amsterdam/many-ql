package org.uva.qls.visitor;

public interface LiteralVisitable {

	public <T> T accept(LiteralVisitor<T> visitor);

}
