package qls.ast.statement;

/**
 * Created by bore on 02/03/15.
 */
public class Question extends Statement
{
    private final String id;

    public Question(String id, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    @Override
    public boolean isStyleDefinition()
    {
        return false;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
