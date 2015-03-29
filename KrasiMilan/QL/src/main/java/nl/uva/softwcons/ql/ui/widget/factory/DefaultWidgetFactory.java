package nl.uva.softwcons.ql.ui.widget.factory;

import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.DateType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.ast.type.TypeVisitor;
import nl.uva.softwcons.ql.ast.type.UndefinedType;
import nl.uva.softwcons.ql.ui.converter.BooleanToBooleanValueConverter;
import nl.uva.softwcons.ql.ui.converter.DateValueConverter;
import nl.uva.softwcons.ql.ui.converter.StringToNumberValueConverter;
import nl.uva.softwcons.ql.ui.converter.StringToStringValueConverter;
import nl.uva.softwcons.ql.ui.widget.CheckboxWidget;
import nl.uva.softwcons.ql.ui.widget.TextFieldWidget;
import nl.uva.softwcons.ql.ui.widget.Widget;

public class DefaultWidgetFactory implements TypeVisitor<Widget>, WidgetFactory {

    @Override
    public Widget getWidget(final Question question) {
        return question.getType().accept(this);
    }

    @Override
    public Widget visit(final BooleanType type) {
        return new CheckboxWidget("Yes", new BooleanToBooleanValueConverter());
    }

    @Override
    public Widget visit(final StringType type) {
        return new TextFieldWidget(new StringToStringValueConverter());
    }

    @Override
    public Widget visit(final NumberType type) {
        return new TextFieldWidget(new StringToNumberValueConverter());
    }

    @Override
    public Widget visit(final DateType type) {
        return new TextFieldWidget(new DateValueConverter());
    }

    @Override
    public Widget visit(final UndefinedType type) {
        throw new UnsupportedOperationException(""); // TODO add message
    }

}
