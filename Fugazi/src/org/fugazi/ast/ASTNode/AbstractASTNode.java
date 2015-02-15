package org.fugazi.ast.ASTNode;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.IVisitable;

/**
 * The Abstract Node of the Abstract Syntax Tree.
 */
public abstract class AbstractASTNode implements IVisitable {

    public <T> T accept(IASTVisitor<T> visitor) {
        return null;
    }
}
