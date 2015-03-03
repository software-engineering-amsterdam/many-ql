package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.style.DefaultTypeStyle;
import org.fugazi.qls.ast.style.Style;

import java.util.List;

public class Page extends AbstractASTQLSNode {

    protected final String name;
    protected final List<Section> sections;
    protected final List<DefaultTypeStyle> defaultStyles;

    public Page(String _name, List<Section> _sections, List<DefaultTypeStyle> _defaultStyles) {
        this.name = _name;
        this.sections = _sections;
        this.defaultStyles = _defaultStyles;
    }

    public String getName() {
        return this.name;
    }
}
