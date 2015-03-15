package ql.ast.statement;

import ql.ast.expression.Expr;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class IfCondition extends Statement
{
    private final Expr condition;
    private final List<Statement> body;

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
    public <T> T accept(StatVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
