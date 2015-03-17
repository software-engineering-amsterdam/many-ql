package org.uva.qls.visitor;

public interface SheetVisitable {
	public <T> T accept(SheetVisitor<T> visitor);
}
