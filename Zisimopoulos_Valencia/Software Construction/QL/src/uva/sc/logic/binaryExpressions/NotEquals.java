package uva.sc.logic.binaryExpressions;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.BooleanAtom;
import uva.sc.logic.Expression;

public class NotEquals extends BinaryExpression{

	public NotEquals(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op !=]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		Expression firstOperand = this.getFirstOperand().evaluate();
		Expression secondOperand = this.getSecondOperand().evaluate();
		return new BooleanAtom(!firstOperand.equals(secondOperand));
	}

}
