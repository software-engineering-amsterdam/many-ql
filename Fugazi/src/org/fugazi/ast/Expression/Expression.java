package org.fugazi.ast.expression;

import org.fugazi.ast.AbstractASTNode;

public abstract class Expression extends AbstractASTNode {

    public abstract String toString();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);
}