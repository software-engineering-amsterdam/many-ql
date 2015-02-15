package org.fugazi.ast.Statement;

import org.fugazi.ast.ASTNode.AbstractASTNode;

/**
 * The statements class. An abstract class the express a statement.
 * It is a Node of the AST.
 */
public abstract class Statement extends AbstractASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();
}
