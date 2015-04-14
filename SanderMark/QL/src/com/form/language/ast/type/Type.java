package com.form.language.ast.type;

import javax.swing.JPanel;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.GenericValue;
import com.form.language.gui.widget.Widget;
import com.form.language.memory.Context;

public abstract class Type {
	
	public abstract Widget createWidget(Question question, Context context, JPanel panel);

    public boolean isBoolType() {
	return false;
    }

    public boolean isErrorType() {
	return false;
    }

    public boolean isStringType() {
	return false;
    }

    public boolean isIntType() {
	return false;
    }

    public abstract GenericValue defaultValue();
    
    
    @Override
    public abstract boolean equals(Object o);
    
    @Override
    public abstract int hashCode();
}
