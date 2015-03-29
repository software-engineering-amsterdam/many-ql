package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.ast.statement.question.Question;
import com.form.language.gui.widget.CheckBox;
import com.form.language.gui.widget.IntegerTextField;
import com.form.language.gui.widget.Label;
import com.form.language.gui.widget.TextField;
import com.form.language.gui.widget.Widget;
import com.form.language.memory.Context;

public class QuestionComponent {

    private Question question;
    private Context rm;
    private JPanel panel;

    public QuestionComponent(Question question, Context rm, Expression ifCondition) {
	this.question = question;
	this.rm = rm;
	this.panel = new JPanel();
	
	this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
	Label label = new Label(question.getText());
	this.panel.add(label.getLabel());

	if (ifCondition != null) {
	    this.panel.setVisible(false);
	    rm.addDependantQuestion(ifCondition, this);

	    ReferenceCollection referenceCollection = new ReferenceCollection();
	    ifCondition.collectIds(referenceCollection);
	    rm.addReference(referenceCollection, ifCondition);
	}
	createQuestionType();
    }

    // TODO: casten to specifc widget needed?
    // TODO: kent beck Case Statements, chapter 3 code smells
    private void createQuestionType() {
	if (question.getType(rm).isBoolType()) {
		Widget checkbox = new CheckBox(question, this, rm);
	    JCheckBox cb = ((CheckBox) checkbox).getCheckBox();
	    panel.add(cb);
	} else if (question.getType(rm).isStringType()) {
		Widget textfield = new TextField(question, this, rm);
	    JTextField tx = ((TextField) textfield).getTextField();
	    panel.add(tx);
	} else {
		Widget textfield = new IntegerTextField(question, this, rm);
	    JTextField tx = ((IntegerTextField) textfield).getTextField();
	    panel.add(tx);
	}
    }

    public Question getQuestion() {
    	return question;
    }
    
	public JPanel getPanel()
	{
		return panel;
	}

    public void checkVisibility(boolean visible) {
    	this.panel.setVisible(visible);
    }
}
