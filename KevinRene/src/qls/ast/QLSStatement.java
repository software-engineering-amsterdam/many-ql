package qls.ast;

import ql.ast.QLNode;
import qls.ast.visitor.QLSStatementVisitor;

public abstract class QLSStatement implements QLNode {	
	public abstract <T> T accept(QLSStatementVisitor<T> visitor);
	
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	@Override
	public abstract String toString();
}