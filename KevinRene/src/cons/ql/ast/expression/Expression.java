package cons.ql.ast.expression;

import cons.ql.ast.ASTNode;

public abstract class Expression implements ASTNode {
	
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */
	public abstract String show();
	
	public String toString() {
		return show();
	}
}
