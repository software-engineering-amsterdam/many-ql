package org.fugazi.qls.ast.style;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.style.style_property.StyleProperty;

import java.util.List;

public class Style extends AbstractASTNode {


    
    private final List<StyleProperty> styleProperties;

    public Style(int _lineNum) {
        super(_lineNum);
        styleProperties = null;
    }

    public Style() {
        styleProperties = null;
    }

    public Style(int _lineNum, List<StyleProperty> _styleProperties) {
        super(_lineNum);
        styleProperties = _styleProperties;
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

    /**
     * Inherits StyleProperties from a base style.
     * @param _baseStyle The base style to be inherited.
     */
    public void inheriteFromStyle(Style _baseStyle) {
        // get base style props.
        for (StyleProperty baseStyleProperty : _baseStyle.styleProperties) {

            // if current style does not contain the base style property,
            // then add it to current style.
            // if exists keep the current property.
            if (!this.styleProperties.contains(baseStyleProperty)) {
                this.styleProperties.add(baseStyleProperty);
            }
        }
    }
}
