package uva.sc.ql.evaluator;

import java.util.Map;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.atom.StringAtom;
import uva.sc.ql.expression.Expression;
import uva.sc.ql.expression.binaryExpressions.Addition;
import uva.sc.ql.expression.binaryExpressions.And;
import uva.sc.ql.expression.binaryExpressions.Division;
import uva.sc.ql.expression.binaryExpressions.Equals;
import uva.sc.ql.expression.binaryExpressions.GreaterThan;
import uva.sc.ql.expression.binaryExpressions.GreaterThanEquals;
import uva.sc.ql.expression.binaryExpressions.LesserThan;
import uva.sc.ql.expression.binaryExpressions.LesserThanEquals;
import uva.sc.ql.expression.binaryExpressions.Modulus;
import uva.sc.ql.expression.binaryExpressions.Multiplication;
import uva.sc.ql.expression.binaryExpressions.NotEquals;
import uva.sc.ql.expression.binaryExpressions.Or;
import uva.sc.ql.expression.binaryExpressions.Substraction;
import uva.sc.ql.expression.unaryExpressions.Minus;
import uva.sc.ql.expression.unaryExpressions.Not;
import uva.sc.ql.gui.helpers.QuestionData;

/**
 * Evaluates expressions using a values table.
 * 
 * @author Pantelis & Satiago
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EvaluatorVisitor implements IQLExpressionNodeVisitor<Expression> {

    private Map<ID, QuestionData> valuesTable;

    public EvaluatorVisitor(Map<ID, QuestionData> table) {
	valuesTable = table;
    }

    public Expression evaluateExpression(Expression expr) {
	return (Expression) expr.accept(this);
    }

    private QuestionData questionData(ID id) {
	return valuesTable.get(id);
    }

    public Expression visit(ID id) {
	return questionData(id).getValue();
    }

    public NumberAtom visit(Addition addition) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) addition
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) addition
		.getSecondOperand().accept(this));
	return new NumberAtom(firstOperand.getValue()
		+ secondOperand.getValue());
    }

    public NumberAtom visit(Substraction sub) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) sub
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) sub
		.getSecondOperand().accept(this));
	return new NumberAtom(firstOperand.getValue()
		- secondOperand.getValue());
    }

    public NumberAtom visit(Multiplication mult) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) mult
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) mult
		.getSecondOperand().accept(this));
	return new NumberAtom(firstOperand.getValue()
		* secondOperand.getValue());
    }

    public NumberAtom visit(Division division) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) division
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) division
		.getSecondOperand().accept(this));
	NumberAtom result = new NumberAtom(0.);
	try {
	    result = new NumberAtom(firstOperand.getValue()
		    / secondOperand.getValue());
	} catch (ArithmeticException e) {
	}
	return result;
    }

    public NumberAtom visit(Modulus mod) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) mod
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) mod
		.getSecondOperand().accept(this));
	NumberAtom result = new NumberAtom(0.);
	try {
	    result = new NumberAtom(firstOperand.getValue()
		    % secondOperand.getValue());
	} catch (ArithmeticException e) {
	}
	return result;
    }

    public BooleanAtom visit(And and) {
	BooleanAtom firstOperand = (BooleanAtom) and.getFirstOperand().accept(
		this);
	BooleanAtom secondOperand = (BooleanAtom) and.getSecondOperand()
		.accept(this);
	BooleanAtom result = new BooleanAtom(false);
	if (firstOperand != null && secondOperand != null) {
	    result = new BooleanAtom(java.lang.Boolean.valueOf(firstOperand
		    .getValue())
		    && java.lang.Boolean.valueOf(secondOperand.getValue()));
	}
	return result;
    }

    public BooleanAtom visit(Or or) {
	BooleanAtom firstOperand = (BooleanAtom) or.getFirstOperand().accept(
		this);
	BooleanAtom secondOperand = (BooleanAtom) or.getSecondOperand().accept(
		this);
	BooleanAtom result = new BooleanAtom(false);
	if (firstOperand != null && secondOperand != null) {
	    result = new BooleanAtom(java.lang.Boolean.valueOf(firstOperand
		    .getValue())
		    || java.lang.Boolean.valueOf(secondOperand.getValue()));
	}
	return result;
    }

    public BooleanAtom visit(Equals eq) {
	Expression firstOperand = (Expression) eq.getFirstOperand()
		.accept(this);
	Expression secondOperand = (Expression) eq.getSecondOperand().accept(
		this);
	return new BooleanAtom(firstOperand.getValue().equals(
		secondOperand.getValue()));
    }

    public BooleanAtom visit(NotEquals notEquals) {
	Expression firstOperand = (Expression) notEquals.getFirstOperand()
		.accept(this);
	Expression secondOperand = (Expression) notEquals.getSecondOperand()
		.accept(this);
	return new BooleanAtom(!firstOperand.getValue().equals(
		secondOperand.getValue()));
    }

    public BooleanAtom visit(GreaterThan greaterThan) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) greaterThan
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) greaterThan
		.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(
		secondOperand.getValue()) == 1);
    }

    public BooleanAtom visit(GreaterThanEquals greaterThanEquals) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) greaterThanEquals
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) greaterThanEquals
		.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(
		secondOperand.getValue()) >= 0);
    }

    public BooleanAtom visit(LesserThan lesserThan) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) lesserThan
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) lesserThan
		.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(
		secondOperand.getValue()) == -1);
    }

    public BooleanAtom visit(LesserThanEquals lesserThanEquals) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) lesserThanEquals
		.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) lesserThanEquals
		.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(
		secondOperand.getValue()) <= 0);
    }

    public NumberAtom visit(Minus minus) {
	NumberAtom operand = (NumberAtom) minus.getOperand().accept(this);
	NumberAtom result = new NumberAtom(0.);
	if (operand != null) {
	    NumberAtom numericalOperand = new NumberAtom(operand.getValue());
	    result = new NumberAtom(numericalOperand.getValue() * (-1));
	}
	return result;
    }

    public BooleanAtom visit(Not not) {
	BooleanAtom operand = (BooleanAtom) not.getOperand().accept(this);
	return new BooleanAtom(!operand.getValue());
    }

    public BooleanAtom visit(BooleanAtom bool) {
	return bool;
    }

    public NumberAtom visit(NumberAtom doub) {
	return doub;
    }

    public StringAtom visit(StringAtom str) {
	return str;
    }

    private NumberAtom getNumericOperandValue(Expression expr) {
	NumberAtom result = new NumberAtom(0.);
	if (expr != null) {
	    result = new NumberAtom((Double) expr.getValue());
	}
	return result;
    }

}
