package org.fugazi.ast.Expression;

import org.fugazi.ast.ASTNode.AbstractASTNode;

/**
 * The Expression class. An abstract class the express an Expression.
 * It is a Node of the AST.
 */
public abstract class Expression extends AbstractASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();
}