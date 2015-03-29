package com.form.language.ast.statement;

import javax.swing.JPanel;

import com.form.language.ast.type.Type;
import com.form.language.gui.components.FormComponent;
import com.form.language.issue.QLToken;
import com.form.language.issue.Warning;
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
	return questionType;
    }

    public String getText() {
	return questionLabel;
    }

    public String getId() {
	return id;
    }

    public void initMemory(Context context) {
	context.setValue(id, questionType.defaultValue());
    }
    
    //TODO: This is not really 'checkType' but rather something like initialization we can't do in the constructor.
    @Override
    public boolean checkType(Context context) {
	context.addQuestion(this);
	checkExistingLabels(context);
	context.addLabel(questionLabel);
	return true;
    }

    private void checkExistingLabels(Context context) {
	if (context.containsLabel(questionLabel)) {
	    context.addWarning(new Warning(tokenInfo, "A question labeled \" + questionLabel + \" already exists"));
	}
    }

    @Override
    public void createGUIComponent(FormComponent guiBuilder, JPanel panel, Context context) {
	guiBuilder.createGUIQuestion(this, panel, context);
    }
}
