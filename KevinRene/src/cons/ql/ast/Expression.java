package cons.ql.ast;

import java.util.List;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public abstract class Expression implements ASTNode {	
	private final List<Expression> operands;
	
	public Expression(List<Expression> operands) {
		this.operands = operands;
	}
	
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */	
	@Override
	public abstract String toString();
	
	public List<Expression> getOperands() {
		return this.operands;
	}
	
	public abstract QLType getType();

	public abstract <T> T accept(Visitor<T> visitor);

}
