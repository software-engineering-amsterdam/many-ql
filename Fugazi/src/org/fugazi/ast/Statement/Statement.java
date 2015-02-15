package org.fugazi.ast.Statement;

import org.fugazi.ast.ASTNode.ASTNode;

/**
 * The statements class. An abstract class the express a statement.
 * It is a Node of the AST.
 */
public abstract class Statement extends ASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();

    // Accept visitor.
    public abstract <T> T accept(IStatementVisitor<T> visitor);
}
