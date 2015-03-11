package nl.uva.softwcons.qls.ast.segment;

import java.util.List;

import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.DefaultStyle;

public class Section extends QuestionRegion implements ASTNode {
    private final String label;
    private final List<QuestionRegion> content;
    private final List<DefaultStyle> styles;

    public Section(final String label, final List<QuestionRegion> content, final List<DefaultStyle> styles) {
        this.label = label;
        this.content = content;
        this.styles = styles;
    }

    public String getLabel() {
        return label;
    }

    public List<QuestionRegion> getContent() {
        return content;
    }

    public List<DefaultStyle> getStyles() {
        return styles;
    }

}
