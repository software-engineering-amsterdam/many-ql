package edu.parser.QLS.nodes;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Style implements AbstractNode<Visitor> {
    private final String style;

    public Style(String style) {
        this.style = style;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
