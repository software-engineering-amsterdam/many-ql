package qls.ast.statement;

import ql.ast.AstNode;

/**
 * Created by bore on 02/03/15.
 */
public abstract class Statement extends AstNode
{
    public Statement(int lineNumber)
    {
        super(lineNumber);
    }

    public abstract boolean isStyleDefinition();

    public abstract <T> T accept(StatementVisitor<T> visitor);
}
