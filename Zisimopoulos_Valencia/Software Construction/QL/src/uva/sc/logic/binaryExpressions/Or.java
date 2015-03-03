package uva.sc.logic.binaryExpressions;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.BooleanAtom;
import uva.sc.logic.Expression;

public class Or extends BinaryExpression{

	public Or(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op ||]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		Expression firstOperand = this.getFirstOperand().evaluate();
		Expression secondOperand = this.getSecondOperand().evaluate();
		BooleanAtom result = null;
		if (firstOperand.equals(BooleanAtom.isFalse()) || secondOperand.equals(BooleanAtom.isFalse())) {
			result = new BooleanAtom(false);
		}
		else {
			result = new BooleanAtom(true);
		}
		return result;
	}
}
