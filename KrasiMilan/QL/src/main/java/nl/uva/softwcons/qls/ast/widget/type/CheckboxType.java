package nl.uva.softwcons.qls.ast.widget.type;

import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.Type;

public class CheckboxType extends WidgetType {
    private final String yes;

    public CheckboxType(final String yes) {
        this.yes = yes;
    }

    public String getYes() {
        return yes;
    }

    @Override
    public boolean isCompatibleWith(Type type) {
        return type == BooleanType.BOOLEAN_TYPE;
    }

}
