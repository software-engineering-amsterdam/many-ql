package nl.uva.softwcons.qls.ast.widget.type;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
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
    public boolean isCompatibleWith(final Type type) {
        return type == BOOLEAN_TYPE;
    }

}
