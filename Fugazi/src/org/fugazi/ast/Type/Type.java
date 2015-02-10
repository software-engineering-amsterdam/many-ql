package org.fugazi.ast.Type;

import org.fugazi.ast.ASTNode.ASTNode;

public abstract class Type extends ASTNode {

    public abstract String toString();
    public abstract boolean equals(Object object);
}
