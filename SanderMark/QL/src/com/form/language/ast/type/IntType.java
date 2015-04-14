package com.form.language.ast.type;

import javax.swing.JPanel;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.GenericValue;
import com.form.language.ast.values.IntValue;
import com.form.language.gui.widget.IntegerTextField;
import com.form.language.gui.widget.Widget;
import com.form.language.memory.Context;

public final class IntType extends Type {

    @Override
    public boolean isIntType() {
	return true;
    }

    @Override
    public String toString() {
	return "Int";
    }

    @Override
    public GenericValue defaultValue() {
	return new IntValue(0);
    }
    
    @Override
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof IntType);
    }
    
    @Override
    public int hashCode() {
	return 1;
    }
    
	@Override
	public Widget createWidget(Question question, Context context, JPanel panel) {
	    IntegerTextField textfield = new IntegerTextField(question, context);
	    panel.add(textfield.getTextField());
	    return textfield;
	}
}
