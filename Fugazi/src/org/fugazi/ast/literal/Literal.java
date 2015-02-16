package org.fugazi.ast.literal;

import org.fugazi.ast.AbstractASTNode;

public abstract class Literal extends AbstractASTNode {

    public abstract String toString();

    public abstract <T> T accept(ILiteralVisitor<T> visitor);
}
