package uva.sc.logic.unaryExpressions;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.BooleanAtom;
import uva.sc.logic.Expression;

public class Not extends UnaryExpression{

	public Not(Expression operand) {
		super(operand);
	}
	
	public String toString() {
		return "[un !]" + operand.getValue();
	}

	@Override
	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		Expression operand = this.getOperand().evaluate();
		BooleanAtom result = null;
		if (operand.equals(BooleanAtom.isTrue())) {
			result = new BooleanAtom(false);
		}
		else {
			result = new BooleanAtom(true);
		}
		return result;
	}

}
