package edu.parser.QLS.nodes;

import edu.nodes.Identifier;
import edu.parser.QLS.QLSVisitor;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class QLSIdentifier implements AbstractNode {

    private final Identifier identifier;

    public QLSIdentifier(String identifier) {
        this.identifier = new Identifier(identifier);
    }

    public String getIdentifier() {
        return identifier.getIdentifier();
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }

    @Override
    public String toString() {
        return identifier.getIdentifier();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QLSIdentifier that = (QLSIdentifier) o;

        return identifier.equals(that.identifier);

    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
