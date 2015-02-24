package lang.ql.ast;

/**
 * Created by bore on 09/02/15.
 */
public abstract class AstNode
{
    private int lineNumber;

    public AstNode()
    {

    }

    public AstNode(int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber()
    {
        return this.lineNumber;
    }
}
