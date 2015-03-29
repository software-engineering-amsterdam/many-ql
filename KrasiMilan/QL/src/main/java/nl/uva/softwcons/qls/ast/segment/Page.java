package nl.uva.softwcons.qls.ast.segment;

import java.util.List;
import java.util.Map;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widgetstyle.StyledWidget;

public class Page implements ASTNode {
    private final Identifier id;
    private final List<PageSegment> segments;
    private final Map<Type, StyledWidget> styles;

    public Page(final Identifier id, final List<PageSegment> regions, final Map<Type, StyledWidget> styles) {
        this.id = id;
        this.segments = regions;
        this.styles = styles;
    }

    public Identifier getId() {
        return id;
    }

    public List<PageSegment> getSegments() {
        return segments;
    }

    public Map<Type, StyledWidget> getStyles() {
        return styles;
    }

    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public <T, V> T accept(final SegmentValueVisitor<T, V> visitor, final V value) {
        return visitor.visit(this, value);
    }

    public LineInfo getLineInfo() {
        return id.getLineInfo();
    }

}
