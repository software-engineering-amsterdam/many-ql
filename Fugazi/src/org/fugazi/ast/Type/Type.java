package org.fugazi.ast.Type;

import org.fugazi.ast.ASTNode.ASTNode;

/**
 * The Type class. An abstract class the express a Type.
 * It is a Node of the AST.
 */
public abstract class Type extends ASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();

    // Accept Visitor
    public abstract <T> T accept(ITypeVisitor<T> visitor);
}
