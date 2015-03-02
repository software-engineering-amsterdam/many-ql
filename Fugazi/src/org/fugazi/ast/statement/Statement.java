package org.fugazi.ast.statement;

import org.fugazi.ast.AbstractASTNode;

public abstract class Statement extends AbstractASTNode {

    public Statement(int _lineNum) {
        super( _lineNum);
    }

    public abstract String toString();

    public abstract <T> T accept(IStatementVisitor<T> visitor);
}
