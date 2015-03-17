package ql.ast.form;

import ql.ast.AstNode;
import ql.ast.statement.Statement;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class Form extends AstNode
{
    private final String id;
    private final List<Statement> body;

    public Form(String id, List<Statement> body, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
        this.body = body;
    }

    public String getId()
    {
        return this.id;
    }

    public List<Statement> getBody()
    {
        return this.body;
    }

    public <T> T accept(FormVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
