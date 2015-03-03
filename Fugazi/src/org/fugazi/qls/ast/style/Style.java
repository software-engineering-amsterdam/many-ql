package org.fugazi.qls.ast.style;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.style.style_property.StyleProperty;

import java.util.List;

public class Style extends AbstractASTQLSNode {
    
    private final List<StyleProperty> styleProperties;

    public Style() {
        styleProperties = null;
    }

    public Style(List<StyleProperty> _styleProperties) {
        this.styleProperties = _styleProperties;
    }
    
    public List<StyleProperty> getStyleProperties() {
        return this.styleProperties;
    }

    public boolean isNull() {
        return false;
    }
}
