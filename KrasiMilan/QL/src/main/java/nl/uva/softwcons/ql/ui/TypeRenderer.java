package nl.uva.softwcons.ql.ui;

import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.DateType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.ast.type.TypeVisitor;
import nl.uva.softwcons.ql.ast.type.UndefinedType;
import nl.uva.softwcons.ql.eval.value.NumberValue;
import nl.uva.softwcons.ql.eval.value.StringValue;
import nl.uva.softwcons.ql.ui.widget.CheckBoxWidget;
import nl.uva.softwcons.ql.ui.widget.TextFieldWidget;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class TypeRenderer implements TypeVisitor<Widget> {

    @Override
    public Widget visit(BooleanType type) {
        return new CheckBoxWidget("Yes");
    }

    @Override
    public Widget visit(StringType type) {
        return new TextFieldWidget(new StringValue(""));
    }

    @Override
    public Widget visit(NumberType type) {
        return new TextFieldWidget(new NumberValue(0));
    }

    @Override
    public Widget visit(DateType type) {
        return new TextFieldWidget(new StringValue(""));
    }

    @Override
    public Widget visit(UndefinedType type) {
        return null;
    }

}
