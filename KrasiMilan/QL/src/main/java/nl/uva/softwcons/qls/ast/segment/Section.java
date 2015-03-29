package nl.uva.softwcons.qls.ast.segment;

import java.util.List;
import java.util.Map;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.widget.StylizedWidget;

public class Section extends PageSegment {
    private final String label;
    private final List<PageSegment> content;
    private final Map<Type, StylizedWidget> styles;
    private final LineInfo lineInfo;

    public Section(final String label, final List<PageSegment> content, final Map<Type, StylizedWidget> styles,
            final LineInfo lineInfo) {
        this.label = label;
        this.content = content;
        this.styles = styles;
        this.lineInfo = lineInfo;
    }

    public String getLabel() {
        return label;
    }

    public List<PageSegment> getContent() {
        return content;
    }

    public Map<Type, StylizedWidget> getStyles() {
        return styles;
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

    @Override
    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public <T, V> T accept(final SegmentValueVisitor<T, V> visitor, final V value) {
        return visitor.visit(this, value);
    }

}
