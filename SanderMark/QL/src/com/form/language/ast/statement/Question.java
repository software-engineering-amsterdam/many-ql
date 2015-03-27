package com.form.language.ast.statement;

import javax.swing.JPanel;

import com.form.language.ast.type.Type;
import com.form.language.gui.components.FormComponent;
import com.form.language.issue.Error;
import com.form.language.issue.QLToken;
import com.form.language.memory.Context;

//TODO :: Seperate each variable?
public class Question extends Statement {
    private String id;
    private String questionLabel;
    private Type questionType;

    public Question(String questionLabel, String id, Type questionType, QLToken tokenInfo) {
	super(tokenInfo);
	this.questionLabel = questionLabel;
	this.id = id;
	this.questionType = questionType;
    }

    public Type getType(Context context) {
	return this.questionType;
    }

    public String getText() {
	return this.questionLabel;
    }

    public String getId() {
	return this.id;
    }

    public void initMemory(Context context) {
	context.setValue(id, questionType.defaultValue());
    }
    
    //TODO: This is not really 'checkType' but rather something like initialization we can't do in the constructor.
    @Override
    public boolean checkType(Context context) {
	context.addQuestion(this);
	checkExistingLabels(context);
	context.addLabel(this.questionLabel);
	return true;
    }

    private void checkExistingLabels(Context context) {
	if (context.containsLabel(questionLabel)) {
	    context.addError(new Error(tokenInfo, "A question with this label already exists"));
	}
    }

    @Override
    public void createGUIComponent(FormComponent guiBuilder, JPanel panel, Context context) {
	guiBuilder.createGUIQuestion(this, panel, context);
    }
}
