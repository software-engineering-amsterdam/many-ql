package qls.ast;

import qls.ast.visitor.Visitor;

public abstract class Statement implements QLSNode {
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	@Override
	public abstract String toString();
	
	public abstract <T> T accept(Visitor<T> visitor);
}