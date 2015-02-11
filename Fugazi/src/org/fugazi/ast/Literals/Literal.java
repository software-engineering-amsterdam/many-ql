package org.fugazi.ast.Literals;

import org.fugazi.ast.ASTNode.ASTNode;

/**
 * The Literal class. An abstract class the express a Literal.
 * It is a Node of the AST.
 */
public abstract class Literal extends ASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();
    
    // Accept Visitor
    public abstract <T> T accept(LiteralVisitor<T> visitor);
}
