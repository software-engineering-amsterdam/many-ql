package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;

import java.util.List;

public class Page extends AbstractASTQLSNode {

    private final String name;
    private final List<Section> sections;
    private final List<DefaultStyleDeclaration> defaultStyles;

    public Page(String _name, List<Section> _sections, List<DefaultStyleDeclaration> _defaultStyles) {
        this.name = _name;
        this.sections = _sections;
        this.defaultStyles = _defaultStyles;
    }

    public String getName() {
        return this.name;
    }
}
