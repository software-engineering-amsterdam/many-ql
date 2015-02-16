package org.fugazi.ast.Type;

import org.fugazi.ast.ASTNode.AbstractASTNode;

/**
 * The Type class. An abstract class the express a Type.
 * It is a Node of the AST.
 */
public abstract class Type extends AbstractASTNode {

    /**
     * Convert to string
     * @return string
     */
    public abstract String toString();
}
