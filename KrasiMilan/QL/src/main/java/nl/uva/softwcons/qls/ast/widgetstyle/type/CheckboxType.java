package nl.uva.softwcons.qls.ast.widgetstyle.type;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.type.Type;

public class CheckboxType extends WidgetType {
    private final String yes;

    public CheckboxType(final String yes, final LineInfo lineInfo) {
        super(lineInfo);
        this.yes = yes;
    }

    public String getYes() {
        return yes;
    }

    @Override
    public boolean isCompatibleWith(final Type type) {
        return type == BOOLEAN_TYPE;
    }

    @Override
    public <T> T accept(final WidgetTypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
