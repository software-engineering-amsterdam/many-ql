package org.fugazi.ast.literal;

import org.fugazi.ast.IASTVisitor;

public class ID extends Literal {

    private final String name;

    public ID(String _name) {
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

