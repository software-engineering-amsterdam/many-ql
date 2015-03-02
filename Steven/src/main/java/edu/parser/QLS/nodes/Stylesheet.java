package edu.parser.QLS.nodes;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Stylesheet implements AbstractNode<Visitor> {
    private final List<AbstractNode> elements;

    public Stylesheet(List<AbstractNode> elements) {
        this.elements = elements;
    }

    public List<AbstractNode> getElements() {
        return elements;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
