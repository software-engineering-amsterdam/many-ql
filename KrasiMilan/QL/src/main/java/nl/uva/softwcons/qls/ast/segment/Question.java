package nl.uva.softwcons.qls.ast.segment;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.widget.StylizedWidget;

public class Question extends PageSegment {
    private final Identifier id;
    private final StylizedWidget widget;

    public Question(final Identifier id) {
        this.id = id;
        this.widget = null;
    }

    public Question(final Identifier id, final StylizedWidget widget) {
        this.id = id;
        this.widget = widget;
    }

    public LineInfo getLineInfo() {
        return id.getLineInfo();
    }

    public Identifier getId() {
        return id;
    }

    public StylizedWidget getStylizedWidget() {
        return widget;
    }

    public boolean hasStylizedWidget() {
        return this.widget != null;
    }

    public boolean isCompatibleWithWidget(final Type questionType) {
        return widget.getWidgetType().isCompatibleWith(questionType);
    }

    @Override
    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
