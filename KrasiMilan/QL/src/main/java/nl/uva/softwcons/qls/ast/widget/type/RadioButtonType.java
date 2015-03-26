package nl.uva.softwcons.qls.ast.widget.type;

import nl.uva.softwcons.ql.ast.type.BooleanType;
import nl.uva.softwcons.ql.ast.type.Type;

public class RadioButtonType extends WidgetType {
    private final String yes;
    private final String no;

    public RadioButtonType(final String yes, final String no) {
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
    public boolean isCompatibleWith(Type type) {
        return type == BooleanType.BOOLEAN_TYPE;
    }

}
