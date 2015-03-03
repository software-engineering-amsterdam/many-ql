package uva.sc.logic.binaryExpressions;

import java.math.BigDecimal;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.NumberAtom;
import uva.sc.logic.Expression;

public class Substraction extends BinaryExpression{

	public Substraction(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	public String toString() {
		return "[op -]";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		Expression firstOperand = this.getFirstOperand().evaluate();
		Expression secondOperand = this.getSecondOperand().evaluate();
		BigDecimal numericalFirstOperand = new BigDecimal(firstOperand.getValue());
		BigDecimal numericalSecondOperand = new BigDecimal(secondOperand.getValue());
		return new NumberAtom(numericalFirstOperand.subtract(numericalSecondOperand).toString());
	}

}
