package nl.uva.softwcons.qls.ast.segment;

import java.util.List;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.DefaultStyle;

public class Page implements ASTNode {
    private final Identifier id;
    private final List<PageSegment> regions;
    private final List<DefaultStyle> styles;

    public Page(final Identifier id, final List<PageSegment> regions, final List<DefaultStyle> styles) {
        this.id = id;
        this.regions = regions;
        this.styles = styles;
    }

    public Identifier getId() {
        return id;
    }

    public List<PageSegment> getRegions() {
        return regions;
    }

    public List<DefaultStyle> getStyles() {
        return styles;
    }

    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
