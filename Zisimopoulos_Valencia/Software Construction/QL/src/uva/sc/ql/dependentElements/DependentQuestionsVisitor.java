package uva.sc.ql.dependentElements;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.atom.StringAtom;
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
import uva.sc.ql.form.Form;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

@SuppressWarnings({ "unchecked" })
public class DependentQuestionsVisitor implements
	IQLExpressionNodeVisitor<Object>, IQLFormNodeVisitor<Object>,
	IQLStatementNodeVisitor<Object> {

    Map<java.lang.String, List<java.lang.String>> dependentElements = new HashMap<java.lang.String, List<java.lang.String>>();
    java.lang.String currentElement;

    public Map<java.lang.String, List<java.lang.String>> getDependentElements() {
	return dependentElements;
    }

    public DependentQuestionsVisitor() {
    }

    public Component visit(Form questionnaire) {
	List<Statement> statements = questionnaire.getStatements();
	for (Statement statement : statements) {
	    statement.accept(this);
	}
	return null;
    }

    public JPanel visit(Question question) {
	currentElement = question.getId().getValue();

	if (question.getExpr() != null) {
	    question.getExpr().accept(this);
	}
	return null;
    }

    public JPanel visit(IfStatement ifStatement) {
	List<Question> questions = ifStatement.getQuestions();

	for (Question question : questions) {
	    question.accept(this);
	    ifStatement.getExpr().accept(this);
	}
	return null;
    }

    public Component visit(ID id) {
	List<java.lang.String> elements = dependentElements.get(id.getValue());
	if (elements == null) {
	    elements = new ArrayList<java.lang.String>();
	}
	elements.add(currentElement);
	dependentElements.put(id.getValue(), elements);
	return null;
    }

    public Component visit(Addition addition) {
	addition.getFirstOperand().accept(this);
	addition.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(And and) {
	and.getFirstOperand().accept(this);
	and.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(Division division) {
	division.getFirstOperand().accept(this);
	division.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(Equals equals) {
	equals.getFirstOperand().accept(this);
	equals.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(GreaterThan greaterThan) {
	greaterThan.getFirstOperand().accept(this);
	greaterThan.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(GreaterThanEquals greaterThanEquals) {
	greaterThanEquals.getFirstOperand().accept(this);
	greaterThanEquals.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(LesserThan lesserThan) {
	lesserThan.getFirstOperand().accept(this);
	lesserThan.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(LesserThanEquals lesserThanEquals) {
	lesserThanEquals.getFirstOperand().accept(this);
	lesserThanEquals.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(Modulus mod) {
	mod.getFirstOperand().accept(this);
	mod.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(Multiplication mult) {
	mult.getFirstOperand().accept(this);
	mult.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(NotEquals notEquals) {
	notEquals.getFirstOperand().accept(this);
	notEquals.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(Or or) {
	or.getFirstOperand().accept(this);
	or.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(Substraction sub) {
	sub.getFirstOperand().accept(this);
	sub.getSecondOperand().accept(this);
	return null;
    }

    public Component visit(Minus minus) {
	minus.getOperand().accept(this);
	return null;
    }

    public Component visit(Not not) {
	not.getOperand().accept(this);
	return null;
    }

    public Component visit(BooleanAtom bool) {
	return null;
    }

    public Component visit(NumberAtom doub) {
	return null;
    }

    public Component visit(StringAtom str) {
	return null;
    }

}
