package nl.uva.softwcons.qls.ast.segment;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.qls.ast.widget.StylizedWidget;

public class Question extends PageSegment {
    private final Identifier id;
    private final StylizedWidget widget;

    public Question(final Identifier id) {
        this.id = id;
        this.widget = new StylizedWidget();
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

    public boolean hasWidget() {
        return this.widget.getWidgetType().isPresent();
    }

    @Override
    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public <T, V> T accept(SegmentValueVisitor<T, V> visitor, V value) {
        return visitor.visit(this, value);
    }

}
