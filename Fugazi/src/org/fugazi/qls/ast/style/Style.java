package org.fugazi.qls.ast.style;

import org.fugazi.qls.ast.AbstractASTNode;
import org.fugazi.qls.ast.style.style_property.StyleProperty;

import java.util.List;

public class Style extends AbstractASTNode {
    
    private final List<StyleProperty> styleProperties;
    
    public Style(List<StyleProperty> _styleProperties) {
        this.styleProperties = _styleProperties;
    }
    
    public List<StyleProperty> getStyleProperties() {
        return this.styleProperties;
    }
}
