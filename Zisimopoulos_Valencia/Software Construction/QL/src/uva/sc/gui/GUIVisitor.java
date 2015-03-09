package uva.sc.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uva.sc.ast.*;
import uva.sc.atom.*;
import uva.sc.evaluator.EvaluatorVisitor;
import uva.sc.logic.Expression;
import uva.sc.logic.Form;
import uva.sc.logic.If_Statement;
import uva.sc.logic.Question;
import uva.sc.logic.Statement;
import uva.sc.logic.binaryExpressions.*;
import uva.sc.logic.unaryExpressions.*;
import uva.sc.types.Boolean;
import uva.sc.types.Number;
import uva.sc.types.String;
import uva.sc.types.Unidentified;

@SuppressWarnings("serial")
public class GUIVisitor extends JFrame implements INodeVisitor<Component>{
	
	List<Component> componentList = new ArrayList<Component>();
	Map<java.lang.String, List<java.lang.String>> dependentElements = new HashMap<java.lang.String, List<java.lang.String>>();

	EvaluatorVisitor evaluator ;
	java.lang.String currentElement;
	java.lang.String if_expression;
	
	public GUIVisitor (EvaluatorVisitor eval){
		evaluator = eval;
	}
	
	public List<Component> getComponentList() {
		return componentList;
	}
	
	public Map<java.lang.String, List<java.lang.String>> getDependentElements() {
		return dependentElements;
	}
	
	public Component getComponentByName(java.lang.String name) {
        Map<java.lang.String, Component> componentMap = new HashMap<java.lang.String,Component>();
        Component result = null;
        for (Component component : componentList) {
            componentMap.put(component.getName(), component);
        }
        if (componentMap.containsKey(name)) {
            result = componentMap.get(name);
	    }
	    return result;
	}
	
	public void addListeners() {
		Iterator it = dependentElements.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        JPanel component = (JPanel)getComponentByName(pair.getKey().toString());
	        for (Component comp : component.getComponents()) {
	        	if (comp instanceof javax.swing.JCheckBox) {
	        		JCheckBox checkBox = (JCheckBox)comp;
	        		checkBox.addActionListener(new VisibilityListener(this));
	        	}
	        	else if (comp instanceof javax.swing.JTextField) {
	        		JTextField textField = (JTextField)comp;
	        		textField.addActionListener(new CalculatorListener(this));
	        	}
	        	else {
	        		//TODO
	        	}
	        }
	    }
	}

	public Component visit(Form questionare) {
		List<Statement> statements = questionare.getStatements();
		for (Statement statement :  statements) {
			statement.accept(this);
		}
		return null;
	}

	public JPanel visit(Question question) {
		uva.sc.gui.Question questionGUI = null;
		currentElement = question.getId().getValue();
		if (question.getType().equals(new Boolean())) {
			questionGUI = new CheckBoxQuestion();
		}
		else {//if (question.getType().equals(new String()) || question.getType().equals(new Number())) {
			if (evaluator.getValuesTable().get(currentElement).getValue() == null) {
				questionGUI = new TextBoxQuestion(this);
			}
			else {
				questionGUI = new CalculatedQuestion(this);
			}
		}
		if (question.getExpr() != null) {
			question.getExpr().accept(this);
		}
		componentList.add(questionGUI.drawQuestion(currentElement, question.getStr()));
		return (JPanel)questionGUI.drawQuestion(currentElement, question.getStr());
	}

	public JPanel visit(If_Statement if_statement) {
		List<Question> questions = if_statement.getQuestions();

		for (Question question : questions) {
			question.accept(this);
			if_statement.getExpr().accept(this);
		}
		return null;
	}

	public Component visit(ID id) {
		List<java.lang.String> elements  = dependentElements.get(id.getValue());
		if(elements == null) {
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

	public Component visit(Power pow) {
		pow.getFirstOperand().accept(this);
		pow.getSecondOperand().accept(this);
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

	public Component visit(Boolean bool) {
		return null;
	}

	public Component visit(String str) {
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

	public Component visit(Number number) {
		return null;
	}

	public Component visit(Unidentified unidentified) {
		return null;
	}	
}
