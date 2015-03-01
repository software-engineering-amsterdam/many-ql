package edu.parser.QLS.nodes;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Stylesheet implements AbstractNode<Visitor> {
    private final List<AbstractNode> elements;
    private final Identifier title;

    public Stylesheet(Identifier title, List<AbstractNode> elements) {
        this.title = title;
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
