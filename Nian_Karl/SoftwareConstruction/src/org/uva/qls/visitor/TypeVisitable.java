package org.uva.qls.visitor;

public interface TypeVisitable {
	
	public <T> T accept(TypeVisitor<T> visitor);
	
}
