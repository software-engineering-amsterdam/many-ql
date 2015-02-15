package org.fugazi.ast.Type;

import org.fugazi.ast.IASTVisitor;

public class BoolType extends Type {

    @Override
    public String toString() {
        return "Bool";
    }

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitBoolType(this);
    }
}
