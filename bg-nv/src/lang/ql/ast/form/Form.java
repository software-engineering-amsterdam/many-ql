package lang.ql.ast.form;

import lang.ql.ast.AstNode;
import lang.ql.ast.statement.Statement;
import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class Form extends AstNode
{
    private String id;
    private List<Statement> statements;

    public Form(String id, List<Statement> statements)
    {
        this.id = id;
        this.statements = statements;
    }

    public Iterable<? extends AstNode> getChildren()
    {
        return this.statements;
    }
}
