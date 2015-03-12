package nl.uva.softwcons.qls.ast.style;

import nl.uva.softwcons.qls.ast.ASTNode;

public class StyleProperty implements ASTNode {
    private final String propertyKey;
    private final String propertyValue;

    public StyleProperty(final String key, final String value) {
        this.propertyKey = key;
        this.propertyValue = value;
    }

}
