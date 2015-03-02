package org.fugazi.ast.type;

import org.fugazi.ast.AbstractASTNode;

public abstract class Type extends AbstractASTNode {

    public Type() {
        super();
    }
    public Type(int _lineNum) {
        super(_lineNum);
    }

    public abstract String toString();

    public abstract <T> T accept(ITypeVisitor<T> visitor);

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return (this.getClass() == obj.getClass());
    }
}
