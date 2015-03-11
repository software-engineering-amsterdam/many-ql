package nl.uva.softwcons.qls.ast.segment;

import java.util.List;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.widget.DefaultStyle;

public class Page implements ASTNode {
    private final Identifier id;
    private final List<QuestionRegion> regions;
    private final List<DefaultStyle> styles;

    public Page(final Identifier id, final List<QuestionRegion> regions, final List<DefaultStyle> styles) {
        this.id = id;
        this.regions = regions;
        this.styles = styles;
    }

    public Identifier getId() {
        return id;
    }

    public List<QuestionRegion> getRegions() {
        return regions;
    }

    public List<DefaultStyle> getStyles() {
        return styles;
    }

}
