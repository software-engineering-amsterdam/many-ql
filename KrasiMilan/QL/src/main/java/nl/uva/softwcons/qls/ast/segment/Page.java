package nl.uva.softwcons.qls.ast.segment;

import java.util.List;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.StylizedType;

public class Page implements ASTNode {
    private final Identifier id;
    private final List<PageSegment> segments;
    private final List<StylizedType> styles;
    private final LineInfo lineInfo;

    public Page(final Identifier id, final List<PageSegment> regions, final List<StylizedType> styles,
            final LineInfo lineInfo) {
        this.id = id;
        this.segments = regions;
        this.styles = styles;
        this.lineInfo = lineInfo;
    }

    public Identifier getId() {
        return id;
    }

    public List<PageSegment> getSegments() {
        return segments;
    }

    public List<StylizedType> getStyles() {
        return styles;
    }

    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

}
