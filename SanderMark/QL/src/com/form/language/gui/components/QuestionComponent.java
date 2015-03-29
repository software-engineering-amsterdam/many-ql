package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.ast.statement.question.Question;
import com.form.language.gui.widget.CheckBox;
import com.form.language.gui.widget.IntegerTextField;
import com.form.language.gui.widget.Label;
import com.form.language.gui.widget.TextField;
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

    //Polymorphism  could be used within type to ask which widget (type) the question is but this would, 
    //increase the responsibilty of the Type.
    private void createQuestionType() {
	if (question.getType(rm).isBoolType()) {
	    CheckBox checkbox = new CheckBox(question, this, rm);
	    panel.add(checkbox.getCheckBox());
	} else if (question.getType(rm).isStringType()) {
	    TextField textfield = new TextField(question, this, rm);
	    panel.add(textfield.getTextField());
	} else {
	    IntegerTextField textfield = new IntegerTextField(question, this, rm);
	    panel.add(textfield.getTextField());
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
