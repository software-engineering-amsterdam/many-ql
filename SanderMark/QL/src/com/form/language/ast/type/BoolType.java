package com.form.language.ast.type;

import javax.swing.JPanel;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.GenericValue;
import com.form.language.gui.widget.CheckBox;
import com.form.language.gui.widget.Widget;
import com.form.language.memory.Context;

public final class BoolType extends Type {

    @Override
    public boolean isBoolType() {
	return true;
    }

    @Override
    public String toString() {
	return "Bool";
    }

    @Override
    public GenericValue defaultValue() {
	return new BoolValue(false);
    }

    @Override
    //This makes sense because there are no fields. Alternative is making this class a Singleton, but that does make the code less readable
    public boolean equals(Object o) {
	return (o instanceof BoolType);
    }
    
    @Override
    public int hashCode() {
	return 3;
    }
    
    @Override
	public Widget createWidget(Question question, Context context, JPanel panel) {
		//BoolType questionType = ((BoolType) type);
		CheckBox checkbox = new CheckBox(question, context);
		panel.add(checkbox.getCheckBox());
		return checkbox;
	}
}
