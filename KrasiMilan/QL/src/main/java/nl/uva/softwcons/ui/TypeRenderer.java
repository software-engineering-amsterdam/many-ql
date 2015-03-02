package nl.uva.softwcons.ui;

import nl.uva.softwcons.ast.type.BooleanType;
import nl.uva.softwcons.ast.type.DateType;
import nl.uva.softwcons.ast.type.DecimalType;
import nl.uva.softwcons.ast.type.IntegerType;
import nl.uva.softwcons.ast.type.StringType;
import nl.uva.softwcons.ast.type.TypeVisitor;
import nl.uva.softwcons.ast.type.UndefinedType;
import nl.uva.softwcons.eval.value.NumberValue;
import nl.uva.softwcons.eval.value.StringValue;
import nl.uva.softwcons.ui.widget.CheckBoxWidget;
import nl.uva.softwcons.ui.widget.TextFieldWidget;
import nl.uva.softwcons.ui.widget.Widget;

public class TypeRenderer implements TypeVisitor<Widget> {

    @Override
    public Widget visit(BooleanType type) {
        return new CheckBoxWidget("Yes");
    }

    @Override
    public Widget visit(IntegerType type) {
        return new TextFieldWidget(new NumberValue(0));
    }

    @Override
    public Widget visit(StringType type) {
        return new TextFieldWidget(new StringValue(""));
    }

    @Override
    public Widget visit(DecimalType type) {
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
