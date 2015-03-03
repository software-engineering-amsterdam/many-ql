package org.fugazi.qls.ast.segment;

import java.util.List;
import org.fugazi.qls.ast.AbstractASTNode;
import org.fugazi.qls.ast.default_style.DefaultStyle;

public abstract class Segment extends AbstractASTNode {
    
    protected final String name;
    protected final List<Section> sections;
    protected final List<DefaultStyle> defaultStyles;
    
    public Segment(String _name, List<Section> _sections, List<DefaultStyle> _defaultStyles) {
        this.name = _name;
        this.sections = _sections;
        this.defaultStyles = _defaultStyles;
    }
    
    public String getName() {
        return this.name;
    }
}
