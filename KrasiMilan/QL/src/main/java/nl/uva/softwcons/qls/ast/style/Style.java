package nl.uva.softwcons.qls.ast.style;

import java.util.ArrayList;
import java.util.List;

import nl.uva.softwcons.qls.ast.ASTNode;

public class Style implements ASTNode {
    private final List<StyleProperty> properties;

    public Style() {
        properties = new ArrayList<StyleProperty>();
    }

    public Style(final List<StyleProperty> properties) {
        this.properties = properties;
    }

    public Style inherit(final Style parentStyle) {

        // TODO
        return parentStyle;

    }

}
