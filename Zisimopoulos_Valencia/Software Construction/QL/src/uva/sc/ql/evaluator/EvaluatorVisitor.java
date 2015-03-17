package uva.sc.ql.evaluator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.*;
import uva.sc.ql.expression.*;
import uva.sc.ql.expression.binaryExpressions.*;
import uva.sc.ql.expression.unaryExpressions.*;
import uva.sc.ql.form.Form;
import uva.sc.ql.gui.DisplayData;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

@SuppressWarnings({"unchecked", "rawtypes"})
public class EvaluatorVisitor extends Observable implements IQLFormNodeVisitor<Expression>, IQLStatementNodeVisitor<Expression>, IQLExpressionNodeVisitor<Expression>{

    Map<java.lang.String, DisplayData> valuesTable = new HashMap<java.lang.String, DisplayData>();

    Expression currentIfCondition = null;

    public Map<java.lang.String, DisplayData> getValuesTable() {
	return valuesTable;
    }
    
    public void putToValuesTable(String s, DisplayData d) {
	valuesTable.put(s, d);
	setChanged();
        notifyObservers();
    }
    
    public Expression visit(Form questionnaire) {
	List<Statement> statements = questionnaire.getStatements();
	for (Statement statement : statements) {
	    statement.accept(this);
	}
	return null;
    }

    public Expression visit(Question question) {
	if (question.getExpr() != null) {
	    putToValuesTable(question.getId().getValue(),
			    new DisplayData(question.getExpr(),
				    currentIfCondition, question.getType()));
	} else {
	    putToValuesTable(question.getId().getValue(), new DisplayData(null,
		    currentIfCondition, question.getType()));
	}
	return null;
    }

    public Expression visit(IfStatement ifStatement) {
	currentIfCondition = ifStatement.getExpr();
	ifStatement.getExpr().accept(this);
	List<Question> questions = ifStatement.getQuestions();
	for (Question question : questions)
	    question.accept(this);
	currentIfCondition = null;
	return null;
    }

    public Expression visit(ID id) {
	return (Expression) valuesTable.get(id.getValue()).getValue();
    }

    public NumberAtom visit(Addition addition) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) addition.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) addition.getSecondOperand().accept(this));
	return new NumberAtom(firstOperand.getValue() + secondOperand.getValue());
    }

    public NumberAtom visit(Substraction sub) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) sub.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) sub.getSecondOperand().accept(this));
	return new NumberAtom(firstOperand.getValue() - secondOperand.getValue());
    }

    public NumberAtom visit(Multiplication mult) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) mult.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) mult.getSecondOperand().accept(this));
	return new NumberAtom(firstOperand.getValue() * secondOperand.getValue());
    }

    public NumberAtom visit(Division division) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) division.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) division.getSecondOperand().accept(this));
	NumberAtom result = new NumberAtom(0.);
	try {
	    result = new NumberAtom(firstOperand.getValue() / secondOperand.getValue());
	} catch (ArithmeticException e) {
	    System.out.println(e.getMessage());
	}
	return result;
    }

    public NumberAtom visit(Modulus mod) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) mod.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) mod.getSecondOperand().accept(this));
	return new NumberAtom(firstOperand.getValue() % secondOperand.getValue());
    }

    public BooleanAtom visit(And and) {
	BooleanAtom firstOperand = (BooleanAtom) and.getFirstOperand().accept(this);
	BooleanAtom secondOperand = (BooleanAtom) and.getSecondOperand().accept(this);
	BooleanAtom result = new BooleanAtom(false);
	if (firstOperand != null && secondOperand != null) {
	    result = new BooleanAtom(java.lang.Boolean.valueOf(firstOperand.getValue()) && java.lang.Boolean.valueOf(secondOperand.getValue()));
	}
	return result;
    }

    public BooleanAtom visit(Or or) {
	BooleanAtom firstOperand = (BooleanAtom) or.getFirstOperand().accept(this);
	BooleanAtom secondOperand = (BooleanAtom) or.getSecondOperand().accept(this);
	BooleanAtom result = new BooleanAtom(false);
	if (firstOperand != null && secondOperand != null) {
	    result = new BooleanAtom(java.lang.Boolean.valueOf(firstOperand.getValue()) || java.lang.Boolean.valueOf(secondOperand.getValue()));
	}
	return result;
    }

    public BooleanAtom visit(Equals eq) {
	Expression firstOperand = (Expression) eq.getFirstOperand().accept(this);
	Expression secondOperand = (Expression) eq.getSecondOperand().accept(this);
	return new BooleanAtom(firstOperand.equals(secondOperand));
    }

    public BooleanAtom visit(NotEquals notEquals) {
	Expression firstOperand = (Expression) notEquals.getFirstOperand().accept(this);
	Expression secondOperand = (Expression) notEquals.getSecondOperand().accept(this);
	return new BooleanAtom(!firstOperand.equals(secondOperand));
    }

    public BooleanAtom visit(GreaterThan greaterThan) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) greaterThan.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) greaterThan.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(secondOperand.getValue()) == 1);
    }

    public BooleanAtom visit(GreaterThanEquals greaterThanEquals) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) greaterThanEquals.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) greaterThanEquals.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(secondOperand.getValue()) >= 0);
    }

    public BooleanAtom visit(LesserThan lesserThan) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) lesserThan.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) lesserThan.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(secondOperand.getValue()) == -1);
    }

    public BooleanAtom visit(LesserThanEquals lesserThanEquals) {
	NumberAtom firstOperand = getNumericOperandValue((Expression) lesserThanEquals.getFirstOperand().accept(this));
	NumberAtom secondOperand = getNumericOperandValue((Expression) lesserThanEquals.getSecondOperand().accept(this));
	return new BooleanAtom(firstOperand.getValue().compareTo(secondOperand.getValue()) <= 0);
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
