package edu.parser.QLS.nodes;

import edu.parser.AbstractNode;
import edu.parser.QLS.Visitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Identifier implements AbstractNode<Visitor> {

    private final String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.accept(this);
    }
}
