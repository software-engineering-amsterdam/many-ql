package org.fugazi.ast.Expression;

import org.fugazi.ast.ASTNode.ASTNode;

/**
 * The Expression class. An abstract class the express an Expression.
 * It is a Node of the AST.
 */
public abstract class Expression extends ASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();

    // Accept Visitor
    public abstract <T> T accept(ExpressionVisitor<T> visitor);
}