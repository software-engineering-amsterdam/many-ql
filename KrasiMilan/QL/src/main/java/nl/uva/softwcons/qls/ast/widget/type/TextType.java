package nl.uva.softwcons.qls.ast.widget.type;

import java.util.Arrays;

import nl.uva.softwcons.ql.ast.type.DateType;
import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.StringType;
import nl.uva.softwcons.ql.ast.type.Type;

public class TextType extends WidgetType {
    private static final Type[] compatibleTypes = { NumberType.NUMBER_TYPE, StringType.STRING_TYPE, DateType.DATE_TYPE };

    @Override
    public boolean isCompatibleWith(Type type) {
        return Arrays.asList(compatibleTypes).contains(type);
    }

}
