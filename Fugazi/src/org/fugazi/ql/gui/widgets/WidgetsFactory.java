package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.ast.type.*;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;


public class WidgetsFactory {

    public IWidget getDefaultWidgetForQuestion(Question _question) {
        Type type = _question.getType();
        String label = _question.getLabel();

        if (type.equals(new BoolType())) {
            return new CheckBox(label);
        }

        if (type.equals(new StringType())) {
            return new TextBox(label);
        }

        if (type.equals(new IntType())) {
            return new IntegerOnlyTextBox(label);
        }

        return null;
    }
    
    public IWidget getDefaultWidgetForQuestion(Question _question, ExpressionValue _value) {
        Type type = _question.getType();
        String label = _question.getLabel();
        
        if (type.equals(new BoolType())) {
            IWidget widget = new CheckBox(label);
            widget.setValue(_value.getValue());
            widget.setReadOnly(true);
            return widget;
        }

        if (type.equals(new StringType())) {
            IWidget widget = new TextBox(label);
            widget.setValue(_value.getValue().toString());
            widget.setReadOnly(true);
            return widget;
        }

        if (type.equals(new IntType())) {
            IWidget widget = new TextBox(label);
            widget.setValue(_value.getValue().toString());
            widget.setReadOnly(true);
            return widget;
        }

        return null;
    }
}