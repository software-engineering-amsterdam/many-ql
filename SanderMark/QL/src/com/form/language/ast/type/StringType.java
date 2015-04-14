package com.form.language.ast.type;

import javax.swing.JPanel;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.StringValue;
import com.form.language.gui.widget.TextField;
import com.form.language.gui.widget.Widget;
import com.form.language.memory.Context;

public final class StringType extends Type {

    @Override
    public boolean isStringType() {
	return true;
    }

    @Override
    public String toString() {
	return "String";
    }

    @Override
    public GenericValue defaultValue() {
	return new StringValue("");
    }

    @Override
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof StringType);
    }

    @Override
    public int hashCode() {
	return 0;
    }
    
    @Override
	public Widget createWidget(Question question, Context context, JPanel panel) {		
	    TextField textfield = new TextField(question, context);
	    panel.add(textfield.getTextField());
	    return textfield;
	}
    
}
