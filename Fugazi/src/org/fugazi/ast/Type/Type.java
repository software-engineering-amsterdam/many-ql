package org.fugazi.ast.Type;

import org.fugazi.ast.ASTNode.ASTNode;

public abstract class Type extends ASTNode {

    /**
     * Constructor.
     */
    public Type() {

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
