package org.fugazi.ast.Statement;

import org.fugazi.ast.ASTNode.ASTNode;

/**
 * The statements class. An abstract class the express a statement.
 * It is a Node of the AST.
 */
public abstract class Statement extends ASTNode {

    /**
     * Constructor.
     */
    public Statement() {
        
    }

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();

    /**
     * Check Equals
     * @param object the object to check
     * @return true if it is equal, false otherwise.
     */
    public abstract boolean equals(Object object);
}
