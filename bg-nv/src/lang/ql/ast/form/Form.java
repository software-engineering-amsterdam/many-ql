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
    private List<Statement> statements;

    public Form(String id, List<Statement> statements, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
        this.statements = statements;
    }

    public String getId()
    {
        return this.id;
    }

    public List<Statement> getStatements()
    {
        return this.statements;
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
