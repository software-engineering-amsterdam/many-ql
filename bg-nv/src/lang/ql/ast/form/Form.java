package lang.ql.ast.form;

import lang.ql.ast.AstNode;
import lang.ql.ast.statement.Statement;
import lang.ql.semantics.Visitor;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class Form extends AstNode
{
    private String id;
    private List<Statement> body;

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

    public void accept(Visitor visitor) { visitor.visit(this); }
}
