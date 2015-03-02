package edu.parser.QLS.nodes.styles;

import edu.parser.AbstractNode;
import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Font extends Style {
    private final String font;

    public Font(String font) {
        this.font = font;
    }

    public String getFont() {
        return font;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
