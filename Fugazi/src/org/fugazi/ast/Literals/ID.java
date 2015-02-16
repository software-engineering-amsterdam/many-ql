package org.fugazi.ast.Literals;

import org.fugazi.ast.IASTVisitor;

/**
 * The identifier.
 */
public class ID extends Literal {

    // The name of the identifier.
    private String name;

    public ID(String _name) {
        this.name = _name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

