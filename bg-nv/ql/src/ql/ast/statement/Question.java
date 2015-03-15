package ql.ast.statement;

import ql.ast.type.Type;

/**
 * Created by bore on 09/02/15.
 */
public class Question extends Statement
{
    private final String id;
    private final Type type;
    private final String label;

    public Question(String id, Type questionType, String label, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
        this.type = questionType;
        this.label = label;
    }

    public String getId()
    {
        return this.id;
    }

    public Type getType()
    {
        return this.type;
    }

    public String getLabel()
    {
        return this.label;
    }

    @Override
    public <T> T accept(StatVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
