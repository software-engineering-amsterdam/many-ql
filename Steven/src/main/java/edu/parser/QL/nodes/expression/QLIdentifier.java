package edu.parser.QL.nodes.expression;

import edu.nodes.Identifier;
import edu.parser.QL.QLVisitor;
import edu.parser.QL.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class QLIdentifier extends Expression {
    private final Identifier identifier;

    public QLIdentifier(String identifier) {
        this.identifier = new Identifier(identifier);
    }

    public String getIdentifier() {
        return identifier.getIdentifier();
    }

    @Override
    public AbstractNode accept(QLVisitor QLVisitor) {
        return QLVisitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QLIdentifier that = (QLIdentifier) o;

        return identifier.equals(that.identifier);

    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public String toString() {
        return identifier.getIdentifier();
    }

    @Override
    public boolean hasBooleanOperands() {
        return true;
    }
}
