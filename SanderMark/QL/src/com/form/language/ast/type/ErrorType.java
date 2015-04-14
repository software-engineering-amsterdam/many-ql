package com.form.language.ast.type;

import javax.swing.JPanel;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.UndefinedValue;
import com.form.language.gui.widget.Widget;
import com.form.language.memory.Context;

public final class ErrorType extends Type {

    @Override
    public boolean isErrorType() {
	return true;
    }

    @Override
    public String toString() {
	return "Error";
    }

    @Override
    public GenericValue defaultValue() {
	return new UndefinedValue();
    }
    
    @Override
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof ErrorType);
    }
    
    @Override
    public int hashCode() {
	return 2;
    }
    
	@Override
	public Widget createWidget(Question question, Context context, JPanel panel) {
		return null;
	}
}
