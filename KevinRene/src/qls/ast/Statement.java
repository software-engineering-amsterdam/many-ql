package qls.ast;

import ql.ast.QLNode;
import qls.ast.visitor.StatementVisitor;

public abstract class Statement implements QLNode {	
	public abstract <T> T accept(StatementVisitor<T> visitor);
	
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	@Override
	public abstract String toString();
}