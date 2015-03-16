package nl.uva.softwcons.qls.ast.segment;

import java.util.List;

import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.DefaultStyle;

public class Section extends PageSegment implements ASTNode {
    private final String label;
    private final List<PageSegment> content;
    private final List<DefaultStyle> styles;

    public Section(final String label, final List<PageSegment> content, final List<DefaultStyle> styles) {
        this.label = label;
        this.content = content;
        this.styles = styles;
    }

    public String getLabel() {
        return label;
    }

    public List<PageSegment> getContent() {
        return content;
    }

    public List<DefaultStyle> getStyles() {
        return styles;
    }

    @Override
    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
