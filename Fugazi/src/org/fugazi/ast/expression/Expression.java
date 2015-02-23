package org.fugazi.ast.expression;

import org.fugazi.ast.AbstractASTNode;

import java.util.List;

public abstract class Expression extends AbstractASTNode {

    public Expression(int _lineNum) {
        super(_lineNum);
    }

    public abstract String toString();

    public abstract Class getReturnedType();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);
}