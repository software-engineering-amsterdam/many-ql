package lang.ql.ast.statement;

import lang.ql.ast.expression.Expr;
import lang.ql.semantics.Visitor;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class IfCondition extends Statement
{
    private Expr condition;
    private List<Statement> body;

    public IfCondition(Expr expr, List<Statement> statements, int lineNumber)
    {
        super(lineNumber);
        this.condition = expr;
        this.body = statements;
    }

    public Expr getCondition()
    {
        return this.condition;
    }

    public List<Statement> getBody()
    {
        return this.body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
