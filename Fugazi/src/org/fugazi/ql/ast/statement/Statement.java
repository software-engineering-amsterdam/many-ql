package org.fugazi.ql.ast.statement;

import org.fugazi.ql.ast.AbstractASTNode;

public abstract class Statement extends AbstractASTNode {

    public Statement() {
    }

    public abstract String toString();

    public abstract <T> T accept(IStatementVisitor<T> visitor);
}
