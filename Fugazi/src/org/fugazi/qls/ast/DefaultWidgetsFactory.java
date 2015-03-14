package org.fugazi.qls.ast;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.widget.QLSCheckBox;
import org.fugazi.qls.ast.widget.QLSSlider;
import org.fugazi.qls.ast.widget.QLSTextBox;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;

public class DefaultWidgetsFactory {

    public AbstractQLSWidget getDefaultWidget(Type _type, String _questionLabel) {

        if (_type.equals(new BoolType())) {
            return new QLSCheckBox(_questionLabel);
        }

        if (_type.equals(new StringType())) {
            return new QLSTextBox(_questionLabel);
        }

        if (_type.equals(new IntType())) {
            return new QLSSlider(_questionLabel);
        }

        return null;
    }
}