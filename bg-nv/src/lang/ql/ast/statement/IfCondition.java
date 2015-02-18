package lang.ql.ast.statement;

import lang.ql.ast.expression.Expr;
import lang.ql.semantics.Visitor;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class IfCondition extends Statement
{
    private Expr expr;
    private List<Statement> statements;

    public IfCondition(Expr expr, List<Statement> statements)
    {
        this.expr = expr;
        this.statements = statements;
    }

    public Expr getExpr()
    {
        return this.expr;
    }

    public List<Statement> getStatements()
    {
        return this.statements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
