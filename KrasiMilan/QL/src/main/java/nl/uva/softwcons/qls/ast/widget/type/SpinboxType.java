package nl.uva.softwcons.qls.ast.widget.type;

import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import nl.uva.softwcons.ql.ast.type.Type;

public class SpinboxType extends WidgetType {

    private final Double start;
    private final Double end;
    private final Double step;

    public SpinboxType(double start, double end, double step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public boolean isCompatibleWith(final Type type) {
        return type == NUMBER_TYPE;
    }

}
