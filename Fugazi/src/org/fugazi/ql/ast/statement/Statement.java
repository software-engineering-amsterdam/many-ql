package org.fugazi.ql.ast.statement;

import org.fugazi.ql.ast.AbstractASTQLNode;

public abstract class Statement extends AbstractASTQLNode {

    public Statement(int _lineNum) {
        super( _lineNum);
    }

    public abstract String toString();

    public abstract <T> T accept(IStatementVisitor<T> visitor);
}
