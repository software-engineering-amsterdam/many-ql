package lang.ql.ast.statement;

import lang.ql.ast.AstNode;

/**
 * Created by bore on 09/02/15.
 */
public abstract class Statement extends AstNode
{
    public Statement(int lineNumber)
    {
        super(lineNumber);
    }

    public abstract <T> T accept(StatVisitor<T> visitor);
}
