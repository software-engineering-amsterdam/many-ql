package nl.uva.softwcons.qls.ast.widget.type;

import nl.uva.softwcons.ql.ast.type.NumberType;
import nl.uva.softwcons.ql.ast.type.Type;

public class SliderType extends WidgetType {

    @Override
    public boolean isCompatibleWith(Type type) {
        return type == NumberType.NUMBER_TYPE;
    }

}
