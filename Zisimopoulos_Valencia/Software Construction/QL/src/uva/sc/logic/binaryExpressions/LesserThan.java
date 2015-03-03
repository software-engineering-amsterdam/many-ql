package uva.sc.logic.binaryExpressions;

import java.math.BigDecimal;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.BooleanAtom;
import uva.sc.logic.Expression;

public class LesserThan extends BinaryExpression{

	public LesserThan(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op <]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		Expression firstOperand = this.getFirstOperand().evaluate();
		Expression secondOperand = this.getSecondOperand().evaluate();
		BigDecimal numericalFirstOperand = new BigDecimal(firstOperand.getValue());
		BigDecimal numericalSecondOperand = new BigDecimal(secondOperand.getValue());
		return new BooleanAtom(numericalFirstOperand.compareTo(numericalSecondOperand) == -1);
	}

}
