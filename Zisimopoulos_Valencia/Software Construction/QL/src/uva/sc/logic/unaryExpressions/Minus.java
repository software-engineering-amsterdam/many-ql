package uva.sc.logic.unaryExpressions;

import java.math.BigDecimal;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.NumberAtom;
import uva.sc.logic.Expression;

public class Minus extends UnaryExpression{

	public Minus(Expression operand) {
		super(operand);
	}
	
	public String toString() {
		return "[un -]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
