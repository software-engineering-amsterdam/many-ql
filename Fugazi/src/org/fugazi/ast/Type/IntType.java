package org.fugazi.ast.Type;

import org.fugazi.ast.IASTVisitor;

/**
 * The Integer type.
 */
public class IntType extends Type {

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitIntType(this);
    }
}
