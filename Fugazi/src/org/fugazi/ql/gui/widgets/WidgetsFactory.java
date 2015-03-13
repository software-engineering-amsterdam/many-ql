package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;


public class WidgetsFactory {

    public IWidget getDefaultWidgetForType(Type _type, String _questionLabel) {

        if (_type.equals(new BoolType())) {
            return new CheckBox(_questionLabel);
        }

        if (_type.equals(new StringType())) {
            return new TextBox(_questionLabel);
        }

        if (_type.equals(new IntType())) {
            return new IntegerOnlyTextBox(_questionLabel);
        }

        return null;
    }
    
    public IWidget getDefaultWidgetForType(Type _type, String _questionLabel, ExpressionValue _value) {

        IWidget widget;

        if (_type.equals(new BoolType())) {
            widget = new CheckBox(_questionLabel);
            widget.setValue(_value.getValue());
            widget.setReadOnly(true);
            return widget;
        }

        if (_type.equals(new StringType())) {
            widget = new TextBox(_questionLabel);
            widget.setValue(_value.getValue().toString());
            widget.setReadOnly(true);
            return widget;
        }

        if (_type.equals(new IntType())) {
            widget = new TextBox(_questionLabel);
            widget.setValue(_value.getValue().toString());
            widget.setReadOnly(true);
            return widget;
        }

        return null;
    }
}