package nl.uva.softwcons.ql.ui;

import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.DateType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.ast.type.TypeVisitor;
import nl.uva.softwcons.ql.ast.type.UndefinedType;
import nl.uva.softwcons.ql.ui.widget.CheckBoxWidget;
import nl.uva.softwcons.ql.ui.widget.TextFieldWidget;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class TypeRenderer implements TypeVisitor<Widget> {

    @Override
    public Widget visit(final BooleanType type) {
        return new CheckBoxWidget("Yes");
    }

    @Override
    public Widget visit(final StringType type) {
        return new TextFieldWidget();
    }

    @Override
    public Widget visit(final NumberType type) {
        return new TextFieldWidget();
    }

    @Override
    public Widget visit(final DateType type) {
        return new TextFieldWidget();
    }

    @Override
    public Widget visit(final UndefinedType type) {
        throw new UnsupportedOperationException(""); // TODO add message
    }

}
