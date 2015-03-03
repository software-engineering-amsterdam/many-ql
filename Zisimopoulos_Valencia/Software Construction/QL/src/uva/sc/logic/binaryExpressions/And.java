package uva.sc.logic.binaryExpressions;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.BooleanAtom;
import uva.sc.logic.Expression;

public class And extends BinaryExpression{

	public And(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op &&]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		Expression firstOperand = this.getFirstOperand().evaluate();
		Expression secondOperand = this.getSecondOperand().evaluate();
		BooleanAtom result = null;
		if (firstOperand.equals(BooleanAtom.isTrue()) && secondOperand.equals(BooleanAtom.isTrue())) {
			result = new BooleanAtom(true);
		}
		else {
			result = new BooleanAtom(false);
		}
		return result;
	}

}
