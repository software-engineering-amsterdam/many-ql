package org.fugazi.ast.type;

import org.fugazi.ast.IASTVisitor;

/**
 * The String type.
 */
public class StringType extends Type {

    @Override
    public String toString() {
        return "String";
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitStringType(this);
    }
}