package edu.parser.QLS.nodes.statement;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;
import edu.parser.QLS.nodes.Style;

import java.util.Optional;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public abstract class Statement implements AbstractNode<Visitor> {

    private final Optional<Style> style;

    protected Statement(Optional<Style> style) {
        this.style = style;
    }

    public Optional<Style> getStyle() {
        return style;
    }
}
