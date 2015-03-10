package org.fugazi.qls.ast;

import org.fugazi.ql.ast.type.BoolType;
import org.fugazi.ql.ast.type.IntType;
import org.fugazi.ql.ast.type.StringType;
import org.fugazi.ql.ast.type.Type;
import org.fugazi.qls.ast.widget.CheckBox;
import org.fugazi.qls.ast.widget.TextBox;
import org.fugazi.qls.ast.widget.Widget;

public class DefaultWidgetsFactory {

    public Widget getDefaultWidget(Type _type) {
        if (_type.equals(new BoolType())) {
            return new CheckBox();
        }

        if (_type.equals(new StringType())) {
            return new TextBox();
        }

        if (_type.equals(new IntType())) {
            return new TextBox();
        }

        return null;
    }
}
