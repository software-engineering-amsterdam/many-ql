package uva.sc.ql.evaluator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uva.sc.ql.ast.INodeVisitor;
import uva.sc.ql.atom.*;
import uva.sc.ql.gui.DisplayData;
import uva.sc.ql.logic.*;
import uva.sc.ql.logic.binaryExpressions.*;
import uva.sc.ql.logic.unaryExpressions.*;
import uva.sc.ql.types.Boolean;
import uva.sc.ql.types.Number;
import uva.sc.ql.types.String;
import uva.sc.ql.types.Unidentified;

public class EvaluatorVisitor implements INodeVisitor<Expression> {

	Map<java.lang.String, DisplayData>	valuesTable			= new HashMap<java.lang.String, DisplayData>();
	Expression							currentIfCondition	= null;

	public Map<java.lang.String, DisplayData> getValuesTable() {
		return valuesTable;
	}

	public Expression visit(Form questionare) {
		List<Statement> statements = questionare.getStatements();
		for (Statement statement : statements) {
			statement.accept(this);
		}
		return null;
	}

	public Expression visit(Expression Expression) {
		return null;
	}

	public Expression visit(Question question) {
		if (question.getExpr() != null) {
			valuesTable.put(question.getId().getValue(), new DisplayData(question.getExpr(), currentIfCondition));
			//question.getExpr().accept(this);
		}
		else {
			valuesTable.put(question.getId().getValue(), new DisplayData(null, currentIfCondition));
		}
		return null;
	}

	public Expression visit(If_Statement if_statement) {
		currentIfCondition = if_statement.getExpr();
		if_statement.getExpr().accept(this);
		List<Question> questions = if_statement.getQuestions();
		for (Question question : questions)
			question.accept(this);
		currentIfCondition = null;
		return null;
	}

	public Expression visit(ID id) {
		return valuesTable.get(id.getValue()).getValue();
	}

	public Expression visit(Addition addition) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(addition).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(addition).getValue());
		return new NumberAtom(firstOperand.add(secondOperand).toString());
	}

	public Expression visit(And and) {
		Expression firstOperand = and.getFirstOperand().accept(this);
		Expression secondOperand = and.getSecondOperand().accept(this);
		BooleanAtom result = new BooleanAtom(false);
		if (firstOperand != null && secondOperand != null) {
			if (java.lang.Boolean.valueOf(firstOperand.getValue()) && java.lang.Boolean.valueOf(secondOperand.getValue())) {
				result = new BooleanAtom(true);
			}
			else {
				result = new BooleanAtom(false);
			}
		}
		return result;
	}

	public Expression visit(Division division) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(division).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(division).getValue());
		NumberAtom result = new NumberAtom("0");
		// check for divide by 0 errors and throw an IllegalArgumentException if detected
		if (secondOperand.doubleValue() != 0) {
			BigDecimal r = firstOperand.divide(secondOperand, 2, RoundingMode.HALF_UP);
			result = new NumberAtom(r.toString());
		}
		else {
			throw new IllegalArgumentException();
		}
		return result;
	}

	public Expression visit(Equals eq) {
		Expression firstOperand = eq.getFirstOperand().accept(this);
		Expression secondOperand = eq.getSecondOperand().accept(this);
		return new BooleanAtom(firstOperand.equals(secondOperand));
	}

	public Expression visit(GreaterThan greaterThan) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(greaterThan).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(greaterThan).getValue());
		return new BooleanAtom(firstOperand.compareTo(secondOperand) == 1);
	}

	public Expression visit(GreaterThanEquals greaterThanEquals) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(greaterThanEquals).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(greaterThanEquals).getValue());
		return new BooleanAtom(firstOperand.compareTo(secondOperand) >= 0);
	}

	public Expression visit(LesserThan lesserThan) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(lesserThan).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(lesserThan).getValue());
		return new BooleanAtom(firstOperand.compareTo(secondOperand) == -1);
	}

	public Expression visit(LesserThanEquals lesserThanEquals) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(lesserThanEquals).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(lesserThanEquals).getValue());
		return new BooleanAtom(firstOperand.compareTo(secondOperand) <= 0);
	}

	public Expression visit(Modulus mod) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(mod).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(mod).getValue());
		return new NumberAtom(firstOperand.remainder(secondOperand).toString());
	}

	public Expression visit(Multiplication mult) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(mult).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(mult).getValue());
		return new NumberAtom(firstOperand.multiply(secondOperand).toString());
	}

	public Expression visit(NotEquals notEquals) {
		Expression firstOperand = notEquals.getFirstOperand().accept(this);
		Expression secondOperand = notEquals.getSecondOperand().accept(this);
		return new BooleanAtom(!firstOperand.equals(secondOperand));
	}

	public Expression visit(Or or) {
		Expression firstOperand = or.getFirstOperand().accept(this);
		Expression secondOperand = or.getSecondOperand().accept(this);
		BooleanAtom result = null;
		if (firstOperand.equals(BooleanAtom.isFalse()) || secondOperand.equals(BooleanAtom.isFalse())) {
			result = new BooleanAtom(false);
		}
		else {
			result = new BooleanAtom(true);
		}
		return result;
	}

	public Expression visit(Substraction sub) {
		BigDecimal firstOperand = new BigDecimal(getFirstNumericOperandValue(sub).getValue());
		BigDecimal secondOperand = new BigDecimal(getSecondNumericOperandValue(sub).getValue());
		return new NumberAtom(firstOperand.subtract(secondOperand).toString());
	}

	public Expression visit(Minus minus) {
		Expression operand = minus.getOperand().accept(this);
		Expression result = new NumberAtom("0");
		if (operand != null) {
			BigDecimal numericalOperand = new BigDecimal(operand.getValue());
			result = new NumberAtom(numericalOperand.multiply(new BigDecimal(-1)).toString());
		}
		return result;
	}

	public Expression visit(Not not) {
		Expression operand = not.getOperand().accept(this);
		BooleanAtom result = null;
		if (operand.equals(BooleanAtom.isTrue())) {
			result = new BooleanAtom(false);
		}
		else {
			result = new BooleanAtom(true);
		}
		return result;
	}

	public Expression visit(Boolean bool) {
		return null;
	}

	public Expression visit(String str) {
		return null;
	}

	public Expression visit(BooleanAtom bool) {
		return bool;
	}

	public Expression visit(NumberAtom doub) {
		return doub;
	}

	public Expression visit(StringAtom str) {
		return str;
	}

	public Expression visit(Number number) {
		return null;
	}

	public Expression visit(Unidentified unidentified) {
		return null;
	}

	private Expression getFirstNumericOperandValue(BinaryExpression expr) {
		NumberAtom result = new NumberAtom("0");
		Expression firstOperand = expr.getFirstOperand().accept(this);
		if (firstOperand != null) {
			result = new NumberAtom(firstOperand.getValue().toString());
		}
		return result;
	}

	private Expression getSecondNumericOperandValue(BinaryExpression expr) {
		NumberAtom result = new NumberAtom("0");
		Expression secondOperand = expr.getSecondOperand().accept(this);
		if (secondOperand != null) {
			result = new NumberAtom(secondOperand.getValue().toString());
		}
		return result;
	}
}
