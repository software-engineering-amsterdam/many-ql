package org.fugazi.ast.expression;

import org.fugazi.ast.AbstractASTNode;
import org.fugazi.ast.type.Type;

public abstract class Expression extends AbstractASTNode {

    public Expression() {
        super();
    }
    public Expression(int _lineNum) {
        super(_lineNum);
    }

    public abstract String toString();

    public abstract Type getReturnedType();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);
}