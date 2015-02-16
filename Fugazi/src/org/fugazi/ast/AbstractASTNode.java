package org.fugazi.ast;

public abstract class AbstractASTNode {

    public <T> T accept(IASTVisitor<T> visitor) {
        return null;
    }
}
