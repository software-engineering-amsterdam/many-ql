package cons.ql.ast;


public abstract class Expression implements ASTNode {
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */	
	@Override
	public abstract String toString();
	
	@Override
	public abstract void accept(Visitor visitor);
}
