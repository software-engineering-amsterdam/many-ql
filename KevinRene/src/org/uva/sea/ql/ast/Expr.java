package org.uva.sea.ql.ast;

public abstract class Expr implements ASTNode {
	
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	public abstract String show();
}
