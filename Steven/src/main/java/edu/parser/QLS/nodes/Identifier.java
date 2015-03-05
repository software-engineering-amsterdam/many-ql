package edu.parser.QLS.nodes;

import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Identifier implements AbstractNode {

    private final String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
