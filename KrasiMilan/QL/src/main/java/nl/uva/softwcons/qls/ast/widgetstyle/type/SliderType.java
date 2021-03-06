package nl.uva.softwcons.qls.ast.widgetstyle.type;

import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.type.Type;

public class SliderType extends WidgetType {
    private final Double start;
    private final Double end;
    private final Double step;

    public SliderType(final double start, final double end, final double step, final LineInfo lineInfo) {
        super(lineInfo);
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public boolean isCompatibleWith(final Type type) {
        return type == NUMBER_TYPE;
    }

    @Override
    public <T> T accept(final WidgetTypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Double getStart() {
        return start;
    }

    public Double getEnd() {
        return end;
    }

    public Double getStep() {
        return step;
    }

}
