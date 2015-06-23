package com.form.language.gui.widget;

import javax.swing.JPanel;

import com.form.language.ast.statement.question.Question;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.IntType;
import com.form.language.ast.type.StringType;
import com.form.language.ast.type.Type;
import com.form.language.ast.type.TypeVisitor;
import com.form.language.memory.Context;

public class WidgetFactory implements TypeVisitor<Widget> {
	private Question question;
	private Context context;
	private JPanel panel;
	
    public Widget createWidget(Question q, Context context, JPanel p) {
    	this.question = q;
    	this.context = context;
    	this.panel = p;
        Type type = q.getType(context);
        return type.accept(this);
    }
    
	@Override
	public Widget visitBoolType(BoolType btype) {
		CheckBox cb = new CheckBox(question, context);
		panel.add(cb.getCheckBox());
		return cb;
	}

	@Override
	public Widget visitIntType(IntType itype) {
	    IntegerTextField itf = new IntegerTextField(question, context);
	    panel.add(itf.getTextField());
	    return itf;
	}

	@Override
	public Widget visitStringType(StringType stype) {
	    TextField tf = new TextField(question, context);
	    panel.add(tf.getTextField());
	    return tf;
	}

	@Override
	public Widget visitErrorType(ErrorType etype) {
		return null;
	}

}
