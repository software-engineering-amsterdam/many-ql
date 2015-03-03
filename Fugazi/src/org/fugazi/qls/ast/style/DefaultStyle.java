package org.fugazi.qls.ast.style;

import org.fugazi.qls.ast.AbstractASTNode;
import org.fugazi.qls.ast.style.style_property.StyleProperty;

import java.util.List;

public class DefaultStyle extends AbstractASTNode {
    
    private final List<StyleProperty> styles;
    
    public DefaultStyle(List<StyleProperty> _styles) {
        this.styles = _styles;
    }
    
    public List<StyleProperty> getStyles() {
        return this.styles;
    }
}
