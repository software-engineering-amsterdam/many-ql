package org.fugazi.ast.Type;

import org.fugazi.ast.ASTNode.ASTNode;

public abstract class Type extends ASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();

    // Accept Visitor
    public abstract <T> T accept(TypeVisitor<T> visitor);
}
