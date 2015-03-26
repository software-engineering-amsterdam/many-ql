package nl.uva.softwcons.qls.ast.widget.type;

import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import nl.uva.softwcons.ql.ast.type.Type;

public class SpinboxType extends WidgetType {

    @Override
    public boolean isCompatibleWith(final Type type) {
        return type == NUMBER_TYPE;
    }

}
