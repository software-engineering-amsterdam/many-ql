package org.fugazi.ast.Type;

import org.fugazi.ast.IASTVisitor;

/**
 * The Undefined type.
 */
public class UndefinedType extends Type {

    @Override
    public String toString() {
        return "Undefined";
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitUndefinedType(this);
    }
}