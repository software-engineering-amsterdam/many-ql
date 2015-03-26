package nl.uva.softwcons.qls.ast.segment;

import java.util.List;

import nl.uva.softwcons.ql.ast.LineInfo;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.StylizedType;

public class Section extends PageSegment implements ASTNode {
    private final String label;
    private final List<PageSegment> content;
    private final List<StylizedType> styles;
    private final LineInfo lineInfo;

    public Section(final String label, final List<PageSegment> content, final List<StylizedType> styles,
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

    public List<StylizedType> getStyles() {
        return styles;
    }

    public LineInfo getLineInfo() {
        return lineInfo;
    }

    @Override
    public <T> T accept(final SegmentVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
