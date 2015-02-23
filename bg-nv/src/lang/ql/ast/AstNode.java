package lang.ql.ast;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public abstract class AstNode
{
    private int lineNumber;

    public abstract <T> T accept(Visitor<T> visitor);

    public AstNode(int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber()
    {
        return this.lineNumber;
    }
}
