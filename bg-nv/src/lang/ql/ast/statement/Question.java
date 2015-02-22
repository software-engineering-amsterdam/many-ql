package lang.ql.ast.statement;

import lang.ql.ast.types.Type;
import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class Question extends Statement
{
    private String id;
    private Type type;
    private String text;

    public Question(String id, Type questionType, String text, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
        this.type = questionType;
        this.text = text;
    }

    public String getId()
    {
        return this.id;
    }

    public Type getType()
    {
        return this.type;
    }

    public String getText()
    {
        return this.text;
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
