package org.fugazi.ql.ast.expression;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.ql.ast.type.Type;

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