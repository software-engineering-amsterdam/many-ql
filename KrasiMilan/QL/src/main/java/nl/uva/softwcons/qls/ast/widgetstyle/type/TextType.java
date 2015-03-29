package nl.uva.softwcons.qls.ast.widgetstyle.type;

import java.util.Arrays;
import java.util.List;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.type.DateType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.ast.type.Type;

public class TextType extends WidgetType {
    private static final List<Type> TEXT_WIDGET_COMPATIBLE_TYPES = Arrays.asList(NumberType.NUMBER_TYPE,
            StringType.STRING_TYPE, DateType.DATE_TYPE);

    public TextType(final LineInfo lineInfo) {
        super(lineInfo);
    }

    @Override
    public boolean isCompatibleWith(final Type type) {
        return TEXT_WIDGET_COMPATIBLE_TYPES.contains(type);
    }

    @Override
    public <T> T accept(final WidgetTypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
