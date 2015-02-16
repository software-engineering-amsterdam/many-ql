package org.fugazi.ast;

import org.fugazi.ast.IASTVisitor;

/**
 * The Abstract Node of the Abstract Syntax Tree.
 */
public abstract class AbstractASTNode {

    public <T> T accept(IASTVisitor<T> visitor) {
        return null;
    }
}
