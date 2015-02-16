package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;

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

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

