package com.form.language.gui.components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.variable.ReferenceCollection;
import com.form.language.ast.statement.question.Question;
import com.form.language.gui.widget.Label;
import com.form.language.gui.widget.Widget;
import com.form.language.gui.widget.WidgetFactory;
import com.form.language.memory.Context;

public class QuestionComponent {

    protected Question question;
    protected Context context;
    protected JPanel panel;
    protected Widget widget;

    public QuestionComponent(Question question, Context context, Expression ifCondition) {
	this.question = question;
	this.context = context;
	this.panel = new JPanel();

	this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));
	Label label = new Label(question.getText());
	this.panel.add(label.getLabel());

	if (ifCondition != null) {
	    this.panel.setVisible(false);
	    context.addDependantQuestion(ifCondition, this);

	    ReferenceCollection referenceCollection = new ReferenceCollection();
	    ifCondition.collectIds(referenceCollection);
	    context.addReference(referenceCollection, ifCondition);
	}
	createQuestionType();
    }
    
    //Increases responsibility of type (by letting it create its widget) which is a trade off to a if/instance of case / maintainability
    private void createQuestionType() {    
	    WidgetFactory w = new WidgetFactory();
	    widget = w.createWidget(question,context,panel);   
    }

    public Question getQuestion() {
	return question;
    }
    public Widget getWidget()
    {
    	return widget;
    }

    public JPanel getPanel()
    {
	return panel;
    }

    public void checkVisibility(boolean visible) {
	this.panel.setVisible(visible);
    }
    
    public void redraw(){
    	this.panel.repaint();
    }
}
