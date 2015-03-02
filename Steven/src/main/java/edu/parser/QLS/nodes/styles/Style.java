package edu.parser.QLS.nodes.styles;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public abstract class Style implements AbstractNode<Visitor> {
    private final String style;

    public Style(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
