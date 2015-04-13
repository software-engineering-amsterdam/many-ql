package com.form.language.ast.statement.question;

import javax.swing.JPanel;

import com.form.language.ast.statement.Statement;
import com.form.language.ast.type.Type;
import com.form.language.gui.components.FormComponent;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

public class Question extends Statement {
    protected QuestionId id;
    protected QuestionLabel label;
    protected Type questionType;

    public Question(String label, String id, Type questionType, QLToken tokenInfo) {
	super(tokenInfo);
	this.id = new QuestionId(id);
	this.label = new QuestionLabel(label);
	this.questionType = questionType;
    }

    public Type getType(Context context) {
	return questionType;
    }

    public String getText() {
	return label.getValue();
    }

    public String getId() {
	return id.getValue();
    }

    public void initMemory(Context context) {
	context.setValue(getId(), questionType.defaultValue());
    }
    
    @Override
    public boolean checkType(Context context) {
	context.addQuestion(this);
	checkExistingLabels(context);
	context.addLabel(getText());
	return true;
    }

    private void checkExistingLabels(Context context) {
    label.checkExistingLabels(context, tokenInfo);
    }

    @Override
    public void createGUIComponent(FormComponent guiBuilder, JPanel panel, Context context) {
	guiBuilder.createGUIQuestion(this, panel, context);
    }
}
