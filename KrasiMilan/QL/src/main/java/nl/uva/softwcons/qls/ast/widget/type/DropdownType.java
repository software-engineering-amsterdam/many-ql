package nl.uva.softwcons.qls.ast.widget.type;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import nl.uva.softwcons.ql.ast.type.Type;

public class DropdownType extends WidgetType {
    private final String yes;
    private final String no;

    public DropdownType(final String yes, final String no) {
        this.yes = yes;
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public String getYes() {
        return yes;
    }

    @Override
    public boolean isCompatibleWith(final Type type) {
        return type == BOOLEAN_TYPE;
    }

}
