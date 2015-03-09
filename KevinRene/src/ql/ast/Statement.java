package ql.ast;

import ql.ast.visitor.StatementVisitor;

public abstract class Statement implements QLNode {
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	@Override
	public abstract String toString();
	
	public abstract <T> T accept(StatementVisitor<T> visitor);
}