package lang.ql.ast.statement;

import lang.ql.ast.type.Type;
import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class Question extends Statement
{
    private String id;
    private Type type;
    private String label;

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

    public <T> T accept(Visitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
